package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.InsurancePolicy;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/insurance-policies")
public interface InsurancePolicyController {

    @PostMapping("/create")
    ResponseEntity<ApiResponse<InsurancePolicy>> createPolicy(@RequestBody InsurancePolicy policy);

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<Optional<InsurancePolicy>>> getPolicyById(@PathVariable Long id);

    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<InsurancePolicy>>> getAllPolicies();

    @GetMapping("/coverage/{coverageType}")
    ResponseEntity<ApiResponse<List<InsurancePolicy>>> findByCoverageType(@PathVariable String coverageType);

    @GetMapping("/active")
    ResponseEntity<ApiResponse<List<InsurancePolicy>>> findActivePolicies();

    @GetMapping("/expiring/{days}")
    ResponseEntity<ApiResponse<List<InsurancePolicy>>> findExpiringPolicies(@PathVariable int days);

    @PutMapping("/update/{id}")
    ResponseEntity<ApiResponse<InsurancePolicy>> updatePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policy);

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deletePolicy(@PathVariable Long id);
}
