package com.rohit.splitwiseclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Entity(name = "SPLITWISE_GROUP")
@AllArgsConstructor
@Data
public class Expense extends BaseModel {
    private String description;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
    @ManyToOne
    private Group group;
    private HashMap<User, Double> paidUser;
    private HashMap<User, Double> hasToPayUser;
}
