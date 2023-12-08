package com.rohit.splitwiseclone.services.Strategy;

import com.rohit.splitwiseclone.Controller.dto.TransactionDTO;
import com.rohit.splitwiseclone.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<TransactionDTO> settleUp(List<Expense> expenses);
}
