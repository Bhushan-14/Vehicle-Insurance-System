package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.InsuranceClaim;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/insurance-claims")
public interface InsuranceClaimController {

    @PostMapping("/create")
    ResponseEntity<ApiResponse<InsuranceClaim>> createInsuranceClaim(@RequestBody InsuranceClaim insuranceClaim);

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<InsuranceClaim>> getInsuranceClaimById(@PathVariable Long id);

    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<InsuranceClaim>>> getAllInsuranceClaims();

    @GetMapping("/status/{status}")
    ResponseEntity<ApiResponse<List<InsuranceClaim>>> findClaimsByStatus(@PathVariable String status);

    @GetMapping("/policy/{policyId}")
    ResponseEntity<ApiResponse<List<InsuranceClaim>>> findClaimsByPolicyId(@PathVariable Long policyId);

    @GetMapping("/above-amount/{amount}")
    ResponseEntity<ApiResponse<List<InsuranceClaim>>> findClaimsAboveAmount(@PathVariable Double amount);

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deleteInsuranceClaim(@PathVariable Long id);
}
