package com.rohit.splitwiseclone.repository;

import com.rohit.splitwiseclone.models.User;
import com.rohit.splitwiseclone.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {

}
