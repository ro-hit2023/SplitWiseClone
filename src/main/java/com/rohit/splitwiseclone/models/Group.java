package com.rohit.splitwiseclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "SplitWise_Group")
@Data
public class Group extends BaseModel {
    private String name;
    private String description;
    @ManyToMany (mappedBy = "group")
    private List<User> users;
    @ManyToMany
    private List<Expense> expenses;
    private double totalAmountSpend;

}
