package com.richard.springbootquerydsl.repository;


import com.richard.springbootquerydsl.model.Admin;
import com.richard.springbootquerydsl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByUsernameAndEmail(String username, String email);
}
