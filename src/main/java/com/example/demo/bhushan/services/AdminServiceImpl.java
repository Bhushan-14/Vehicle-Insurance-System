package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.Admin;
import com.example.demo.bhushan.dao.repositries.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin createAdmin(Admin admin) {
        log.info("Creating new admin: {}", admin);
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        log.info("Fetching admin by id: {}", id);
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    @Override
    public List<Admin> getAllAdmins() {
        log.info("Fetching all admins");
        return adminRepository.findAll();
    }

    @Override
    public List<Admin> findByRole(String role) {
        log.info("Fetching admins by role: {}", role);
        return adminRepository.findByRole(role);
    }

    @Override
    public void deleteAdmin(Long id) {
        log.info("Deleting admin with id: {}", id);
        Admin admin = getAdminById(id);
        adminRepository.delete(admin);
    }
}
