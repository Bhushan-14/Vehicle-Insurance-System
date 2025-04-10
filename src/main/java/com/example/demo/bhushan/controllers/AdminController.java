package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.Admin;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
public interface AdminController {

    @PostMapping("/create")
    ResponseEntity<ApiResponse<Admin>> createAdmin(@RequestBody Admin admin);

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<Admin>> getAdminById(@PathVariable Long id);

    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<Admin>>> getAllAdmins();

    @GetMapping("/role/{role}")
    ResponseEntity<ApiResponse<List<Admin>>> findByRole(@PathVariable String role);

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deleteAdmin(@PathVariable Long id);
}
