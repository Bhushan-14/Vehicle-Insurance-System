package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.Customer;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import com.example.demo.bhushan.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<ApiResponse<Customer>> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(ApiResponse.success(savedCustomer, "Customer created successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<Customer>> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(ApiResponse.success(customer, "Customer fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Customer>>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(ApiResponse.success(customers, "All customers fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Customer>>> findByName(@PathVariable String name) {
        List<Customer> customers = customerService.findByName(name);
        return ResponseEntity.ok(ApiResponse.success(customers, "Customers with name fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<Customer>> findByEmail(@PathVariable String email) {
        Customer customer = customerService.findByEmail(email);
        return ResponseEntity.ok(ApiResponse.success(customer, "Customer with email fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Customer>>> findActiveCustomers() {
        List<Customer> customers = customerService.findActiveCustomers();
        return ResponseEntity.ok(ApiResponse.success(customers, "Active customers fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Customer>>> findCustomersRegisteredAfter(@PathVariable String date) {
        List<Customer> customers = customerService.findCustomersRegisteredAfter(date);
        return ResponseEntity.ok(ApiResponse.success(customers, "Customers registered after date fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<String>> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(ApiResponse.success("Customer deleted successfully", "Success"));
    }
}
