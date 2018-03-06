package com.richard.springbootquerydsl.repository;

import com.richard.springbootquerydsl.model.User;
import com.richard.springbootquerydsl.repository.queydsl.UserRepositoryQueryDsl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User, Long>, UserRepositoryQueryDsl {

}
