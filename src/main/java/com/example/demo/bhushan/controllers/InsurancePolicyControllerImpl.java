package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.InsurancePolicy;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import com.example.demo.bhushan.services.InsurancePolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InsurancePolicyControllerImpl implements InsurancePolicyController {

    private final InsurancePolicyService insurancePolicyService;

    public InsurancePolicyControllerImpl(InsurancePolicyService insurancePolicyService) {
        this.insurancePolicyService = insurancePolicyService;
    }

    @Override
    public ResponseEntity<ApiResponse<InsurancePolicy>> createPolicy(@RequestBody InsurancePolicy policy) {
        InsurancePolicy savedPolicy = insurancePolicyService.createPolicy(policy);
        return ResponseEntity.ok(ApiResponse.success(savedPolicy, "Insurance policy created successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<Optional<InsurancePolicy>>> getPolicyById(@PathVariable Long id) {
        Optional<InsurancePolicy> policy = insurancePolicyService.getPolicyById(id);
        return ResponseEntity.ok(ApiResponse.success(policy, "Insurance policy fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<InsurancePolicy>>> getAllPolicies() {
        List<InsurancePolicy> policies = insurancePolicyService.getAllPolicies();
        return ResponseEntity.ok(ApiResponse.success(policies, "All insurance policies fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<InsurancePolicy>>> findByCoverageType(@PathVariable String coverageType) {
        List<InsurancePolicy> policies = insurancePolicyService.findByCoverageType(coverageType);
        return ResponseEntity.ok(ApiResponse.success(policies, "Policies by coverage type fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<InsurancePolicy>>> findActivePolicies() {
        List<InsurancePolicy> activePolicies = insurancePolicyService.findActivePolicies();
        return ResponseEntity.ok(ApiResponse.success(activePolicies, "Active policies fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<InsurancePolicy>>> findExpiringPolicies(@PathVariable int days) {
        List<InsurancePolicy> expiringPolicies = insurancePolicyService.findExpiringPolicies(days);
        return ResponseEntity.ok(ApiResponse.success(expiringPolicies, "Expiring policies fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<InsurancePolicy>> updatePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policy) {
        InsurancePolicy updatedPolicy = insurancePolicyService.updatePolicy(id, policy);
        return ResponseEntity.ok(ApiResponse.success(updatedPolicy, "Insurance policy updated successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<String>> deletePolicy(@PathVariable Long id) {
        insurancePolicyService.deletePolicy(id);
        return ResponseEntity.ok(ApiResponse.success("Insurance policy deleted successfully", "Success"));
    }
}
