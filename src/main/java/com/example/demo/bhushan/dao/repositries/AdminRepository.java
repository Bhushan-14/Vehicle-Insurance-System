package com.example.demo.bhushan.dao.repositries;

import com.example.demo.bhushan.dao.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a WHERE a.role = :role")
    List<Admin> findByRole(@Param("role") String role);

    @Query("SELECT a FROM Admin a WHERE LOWER(a.username) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Admin> searchByUsername(@Param("keyword") String keyword);
}
