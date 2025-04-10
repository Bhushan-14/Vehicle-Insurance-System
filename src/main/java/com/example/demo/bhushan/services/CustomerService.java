package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.Customer;
import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    List<Customer> findByName(String name);
    Customer findByEmail(String email);
    List<Customer> findActiveCustomers();
    List<Customer> findCustomersRegisteredAfter(String date);
    void deleteCustomer(Long id);
}
