package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.Admin;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import com.example.demo.bhushan.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminControllerImpl implements AdminController {

    private final AdminService adminService;

    public AdminControllerImpl(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public ResponseEntity<ApiResponse<Admin>> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok(ApiResponse.success(savedAdmin, "Admin created successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<Admin>> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(ApiResponse.success(admin, "Admin fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Admin>>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(ApiResponse.success(admins, "All admins fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Admin>>> findByRole(@PathVariable String role) {
        List<Admin> admins = adminService.findByRole(role);
        return ResponseEntity.ok(ApiResponse.success(admins, "Admins with role fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<String>> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok(ApiResponse.success("Admin deleted successfully", "Success"));
    }
}
