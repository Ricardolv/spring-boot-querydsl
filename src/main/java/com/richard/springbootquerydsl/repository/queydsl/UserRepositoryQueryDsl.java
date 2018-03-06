package com.richard.springbootquerydsl.repository.queydsl;

import com.richard.springbootquerydsl.model.User;

import java.util.List;

public interface UserRepositoryQueryDsl {

    List<User> findUserByUsernameAndEmail(String username, String email);
    User findByEmail(String email);
}
