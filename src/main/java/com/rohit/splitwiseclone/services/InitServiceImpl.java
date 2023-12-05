package com.rohit.splitwiseclone.services;

import com.rohit.splitwiseclone.repository.ExpenseRepository;
import com.rohit.splitwiseclone.repository.GroupRepository;
import com.rohit.splitwiseclone.repository.UserExpenseRepository;
import com.rohit.splitwiseclone.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitServiceImpl implements InitService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Override
    public void initialise() {
        User rohit = User.builder()
                        .email("rhtkumar700@gmail.com")
                            .phoneNumber("5802595921")
                                 .name("Rohit Kumar").build();

        User mohit = User.builder()
                .email("rhtkumar800@gmail.com")
                .phoneNumber("8202595921")
                .name("Mohit Kumar").build();

        User tohit = User.builder()
                .email("rhtkumar900@gmail.com")
                .phoneNumber("6802595921")
                .name("tohit Kumar").build();

        User sohit = User.builder()
                .email("rhtkumar000@gmail.com")
                .phoneNumber("9802595921")
                .name("sohit Kumar").build();

        userRepository.save(rohit);
        userRepository.save(mohit);
        userRepository.save(tohit);
        userRepository.save(sohit);

    }
}
