package com.rohit.splitwiseclone.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Entity(name = "SPLITWISE_GROUP")
@Data
public class Expense extends BaseModel {
    private String description;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
    @ManyToOne
    private Group group;
    @OneToMany
    private List<UserExpense> userExpenses;
}
