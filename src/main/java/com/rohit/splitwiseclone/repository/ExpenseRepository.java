package com.rohit.splitwiseclone.repository;

import com.rohit.splitwiseclone.models.Expense;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
