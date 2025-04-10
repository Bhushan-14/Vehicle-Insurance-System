package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.Admin;
import java.util.List;

public interface AdminService {
    Admin createAdmin(Admin admin);
    Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    List<Admin> findByRole(String role);
    void deleteAdmin(Long id);
}
