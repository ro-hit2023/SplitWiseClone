package com.rohit.splitwiseclone.services;

import com.rohit.splitwiseclone.models.Currency;
import com.rohit.splitwiseclone.models.Expense;
import com.rohit.splitwiseclone.models.UserExpense;
import com.rohit.splitwiseclone.repository.ExpenseRepository;
import com.rohit.splitwiseclone.repository.GroupRepository;
import com.rohit.splitwiseclone.repository.UserExpenseRepository;
import com.rohit.splitwiseclone.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Override
    public void initialise() {


        User rohit = User.builder()
                        .email("rhtkumar700@gmail.com")
                            .phoneNumber("5802595921")
                                 .name("Rohit Kumar").build();

        User mohit = User.builder()
                .email("rhtkumar800@gmail.com")
                .phoneNumber("8202595921")
                .name("Mohit Kumar").build();

        User tohit = User.builder()
                .email("rhtkumar900@gmail.com")
                .phoneNumber("6802595921")
                .name("tohit Kumar").build();

        User sohit = User.builder()
                .email("rhtkumar000@gmail.com")
                .phoneNumber("9802595921")
                .name("sohit Kumar").build();

        rohit = userRepository.save(rohit);
        mohit = userRepository.save(mohit);
        tohit = userRepository.save(tohit);
        sohit = userRepository.save(sohit);

        Group group = new Group();
        group.setDescription("Trip to Almora");
        group.setName("Alpha");
        group.setUsers(List.of(rohit, mohit, tohit, sohit));

        groupRepository.save(group);

        // 4 Expense--
        //ex --> amount- 1000, paidBy- rohit, hasTopay- everyone else
        UserExpense userExpense1 = new UserExpense();
        userExpense1.setUser(rohit);
        userExpense1.setAmount(1000);
        userExpense1.setUserExpenseType(UserExpenseType.PAID);
        userExpense1 = userExpenseRepository.save(userExpense1);

        UserExpense userExpense2 = new UserExpense();
        userExpense2.setUser(mohit);
        userExpense2.setAmount(2000);
        userExpense2.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense2 = userExpenseRepository.save(userExpense2);

        UserExpense userExpense3 = new UserExpense();
        userExpense3.setUser(tohit);
        userExpense3.setAmount(3000);
        userExpense3.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense3 = userExpenseRepository.save(userExpense3);

        UserExpense userExpense4 = new UserExpense();
        userExpense4.setUser(sohit);
        userExpense4.setAmount(3000);
        userExpense4.setUserExpenseType(UserExpenseType.HAS_TO_PAY);
        userExpense4 = userExpenseRepository.save(userExpense4);

        Expense expense = new Expense();
        expense.setAmount(9000);
        expense.setDescription("Dinner");
        expense.setCurrency(Currency.INR);
        expense.setUserExpenses(List.of(userExpense1, userExpense2, userExpense3, userExpense4));

        expenseRepository.save(expense);

    }
}
