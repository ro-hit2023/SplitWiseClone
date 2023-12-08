package com.rohit.splitwiseclone.services.Strategy;

import com.rohit.splitwiseclone.Controller.dto.TransactionDTO;
import com.rohit.splitwiseclone.models.Expense;
import com.rohit.splitwiseclone.models.UserExpense;
import org.apache.catalina.User;

import java.util.*;

public class HeapBasedSettleUpStrategy implements  SettleUpStrategy{

    @Override
    public List<TransactionDTO> settleUp(List<Expense> expenses) {
       HashMap<User, Double> userOutstandingMap = new HashMap<>();
       List<TransactionDTO> transactionList = new ArrayList<>();
       for(Expense expense : expenses){
           for(UserExpense userExpense : expense.getUserExpenses()){
               User user = userExpense.getUser();
               double currentOutStandingAmount = userOutstandingMap.getOrDefault(user, 0.00);
               userOutstandingMap.put(user, getUpdatedOutStandingAmount(currentOutStandingAmount, userExpense));
           }
       }
        PriorityQueue<Map.Entry<User, Double>> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getValue(), a.getValue())
        );

       PriorityQueue<Map.Entry<User, Double>> minHeap = new PriorityQueue<>(
               Comparator.comparingDouble(Map.Entry::getValue)
       );

       for(Map.Entry<User, Double> entry : userOutstandingMap.entrySet()){
           if(entry.getValue() < 0){
               minHeap.add(entry);
           }else if(entry.getValue() > 0){
               maxHeap.add(entry);
           }else{
               System.out.println(entry.getKey().getName() + "is already settled, no need to be part of transaction");
           }
       }

        while(!minHeap.isEmpty()) {
            Map.Entry<User, Double> maxHasToPay = minHeap.poll();
            Map.Entry<User, Double> maxPaid = maxHeap.poll();
            TransactionDTO transaction = new TransactionDTO(
                    maxHasToPay.getKey().getName(),
                    maxPaid.getKey().getName(),
                    Math.min(Math.abs(maxHasToPay.getValue()), Math.abs(maxPaid.getValue())));

            transactionList.add(transaction);

            double outstanding = maxPaid.getValue() + maxHasToPay.getValue();
            if (outstanding < 0) {
                maxHasToPay.setValue(outstanding);
                minHeap.add(maxHasToPay);
            } else if (outstanding > 0) {
                maxPaid.setValue(outstanding);
                maxHeap.add(maxPaid);
            } else {
                System.out.println("Settled");
            }
        }
        return transactionList;
    }
    private double getUpdatedOutStandingAmount(double currentOutStandingAmount, UserExpense userExpense) {
        if (userExpense.getUserExpenseType().equals(UserExpenseType.PAID)) {
            currentOutStandingAmount = currentOutStandingAmount + userExpense.getAmount();
        } else {
            currentOutStandingAmount = currentOutStandingAmount - userExpense.getAmount();
        }
        return currentOutStandingAmount;
    }
     /*
        1. Go through all the expenses and find the outstanding amount for each user
            a. Loop through each expense, and for each expense
            b. We will loop through all the userExpense
            If userExpense type is PAID, it will be added as +ve
            If userExpense type is HASTOPAY, it will be subtracted as -ve
            from each user
       2. All the users with negative balance [hasToPay] => minHeap
       3. All the users with positive balance [paid] => maxHeap
       4. We will find the transactions



       {A:-200, B:-100} - minHeap
       {C:150, D:150} - maxHeap

       A => -200
       C => 150

       A will transfer to C -> 150

       C + A => 150 - 200 =>  -50 -> minHeap


       B => -100
       D => 150

       D + B => 150 - 100 =>  50 -> maxHeap


       OP : 0 -> nothing will go back || settled

     */
}

