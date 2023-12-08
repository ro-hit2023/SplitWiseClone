package com.rohit.splitwiseclone.services;

import com.rohit.splitwiseclone.Controller.dto.TransactionDTO;
import com.rohit.splitwiseclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

   @Autowired
    UserRepository userRepository;//ideal way should be to call a method in userService that calls the userRepository to get the users
    @Override
    public List<TransactionDTO> settleUp() {//suppose if we have to change this settleUp algorithm in future so we will use "Strategy design pattern"
        return null;
    }
}
