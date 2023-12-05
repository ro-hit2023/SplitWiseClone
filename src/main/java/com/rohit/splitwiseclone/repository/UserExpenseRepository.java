package com.rohit.splitwiseclone.repository;

import com.rohit.splitwiseclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExpenseRepository extends JpaRepository<User, Long> {

}
