package com.richard.springbootquerydsl.service;

import com.richard.springbootquerydsl.model.User;
import com.richard.springbootquerydsl.repository.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private Users users;


    public List<User> findUsersByUsernameAndEmail(String username, String email) {
        return users.findUserByUsernameAndEmail(username, email);
    }

    public User save(User user) {
       return users.save(user);
    }

    public User findByEmail(String email) {
        return users.findByEmail(email);
    }
}
