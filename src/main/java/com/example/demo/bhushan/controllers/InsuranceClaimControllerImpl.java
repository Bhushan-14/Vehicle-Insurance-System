package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.InsuranceClaim;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import com.example.demo.bhushan.services.InsuranceClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsuranceClaimControllerImpl implements InsuranceClaimController {

    private final InsuranceClaimService insuranceClaimService;

    public InsuranceClaimControllerImpl(InsuranceClaimService insuranceClaimService) {
        this.insuranceClaimService = insuranceClaimService;
    }

    @Override
    public ResponseEntity<ApiResponse<InsuranceClaim>> createInsuranceClaim(@RequestBody InsuranceClaim insuranceClaim) {
        InsuranceClaim savedClaim = insuranceClaimService.createInsuranceClaim(insuranceClaim);
        return ResponseEntity.ok(ApiResponse.success(savedClaim, "Insurance claim created successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<InsuranceClaim>> getInsuranceClaimById(@PathVariable Long id) {
        InsuranceClaim claim = insuranceClaimService.getInsuranceClaimById(id);
        return ResponseEntity.ok(ApiResponse.success(claim, "Insurance claim fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<InsuranceClaim>>> getAllInsuranceClaims() {
        List<InsuranceClaim> claims = insuranceClaimService.getAllInsuranceClaims();
        return ResponseEntity.ok(ApiResponse.success(claims, "All insurance claims fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<InsuranceClaim>>> findClaimsByStatus(@PathVariable String status) {
        List<InsuranceClaim> claims = insuranceClaimService.findClaimsByStatus(status);
        return ResponseEntity.ok(ApiResponse.success(claims, "Claims with status fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<InsuranceClaim>>> findClaimsByPolicyId(@PathVariable Long policyId) {
        List<InsuranceClaim> claims = insuranceClaimService.findClaimsByPolicyId(policyId);
        return ResponseEntity.ok(ApiResponse.success(claims, "Claims with policy ID fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<InsuranceClaim>>> findClaimsAboveAmount(@PathVariable Double amount) {
        List<InsuranceClaim> claims = insuranceClaimService.findClaimsAboveAmount(amount);
        return ResponseEntity.ok(ApiResponse.success(claims, "Claims above amount fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<String>> deleteInsuranceClaim(@PathVariable Long id) {
        insuranceClaimService.deleteInsuranceClaim(id);
        return ResponseEntity.ok(ApiResponse.success("Insurance claim deleted successfully", "Success"));
    }
}
