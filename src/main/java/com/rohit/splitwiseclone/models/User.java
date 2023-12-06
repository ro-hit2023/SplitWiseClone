package com.rohit.splitwiseclone.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



import java.util.List;

@Data
@Entity
@Builder
public class User extends BaseModel {
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany
    private List<Expense> expenses;
    @ManyToMany
    private List<Group> groups;

}
// Mapping
// User to Expense --> 1 user can have many expenses and 1 expense can belong to may users --> ManyToMany
// User to Group --> 1 user can be in many groups and 1 Group can have many users --> ManyTOMany