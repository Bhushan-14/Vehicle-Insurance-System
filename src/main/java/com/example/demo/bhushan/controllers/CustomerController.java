package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.Customer;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
public interface CustomerController {

    @PostMapping("/create")
    ResponseEntity<ApiResponse<Customer>> createCustomer(@RequestBody Customer customer);

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<Customer>> getCustomerById(@PathVariable Long id);

    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<Customer>>> getAllCustomers();

    @GetMapping("/name/{name}")
    ResponseEntity<ApiResponse<List<Customer>>> findByName(@PathVariable String name);

    @GetMapping("/email/{email}")
    ResponseEntity<ApiResponse<Customer>> findByEmail(@PathVariable String email);

    @GetMapping("/active")
    ResponseEntity<ApiResponse<List<Customer>>> findActiveCustomers();

    @GetMapping("/registered-after/{date}")
    ResponseEntity<ApiResponse<List<Customer>>> findCustomersRegisteredAfter(@PathVariable String date);

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deleteCustomer(@PathVariable Long id);
}
