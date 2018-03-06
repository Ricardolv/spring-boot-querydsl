package com.richard.springbootquerydsl.service;

import com.richard.springbootquerydsl.model.Admin;
import com.richard.springbootquerydsl.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findAdminByUsernameAndEmail(String username, String email) {
        return adminRepository.findByUsernameAndEmail(username,email);
    }

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }
}
