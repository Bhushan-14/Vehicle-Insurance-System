package com.example.demo.bhushan.dao.repositries;

import com.example.demo.bhushan.dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Customer> findByName(@Param("name") String name);

    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(@Param("email") String email);

    @Query("SELECT c FROM Customer c WHERE c.isActive = true")
    List<Customer> findActiveCustomers();

    @Query("SELECT c FROM Customer c WHERE c.registrationDate > :date")
    List<Customer> findCustomersRegisteredAfter(@Param("date") LocalDate date);
}
