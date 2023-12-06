package com.rohit.splitwiseclone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity(name = "SplitWise UserExpense")
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;
    private double amount;
    @ManyToOne
    private Expense expense;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}