package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.Customer;
import com.example.demo.bhushan.dao.repositries.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        log.info("Creating new customer: {}", customer);
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        log.info("Fetching customer with ID: {}", id);
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        log.info("Fetching all customers");
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByName(String name) {
        log.info("Searching customers by name: {}", name);
        return customerRepository.findByName(name);
    }

    @Override
    public Customer findByEmail(String email) {
        log.info("Fetching customer by email: {}", email);
        return customerRepository.findByEmail(email);
    }

    @Override
    public List<Customer> findActiveCustomers() {
        log.info("Fetching all active customers");
        return customerRepository.findActiveCustomers();
    }

    @Override
    public List<Customer> findCustomersRegisteredAfter(String date) {
        log.info("Fetching customers registered after: {}", date);
        
        LocalDate localDate = LocalDate.parse(date);
        
        return customerRepository.findCustomersRegisteredAfter(localDate);
    }

    public List<Customer> findCustomersRegisteredAfterCustomFormat(String date) {
        log.info("Fetching customers registered after (Custom Format dd-MM-yyyy): {}", date);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        
        return customerRepository.findCustomersRegisteredAfter(localDate);
    }

    @Override
    public void deleteCustomer(Long id) {
        log.info("Deleting customer with ID: {}", id);
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
