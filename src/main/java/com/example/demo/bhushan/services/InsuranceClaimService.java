package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.InsuranceClaim;
import java.util.List;

public interface InsuranceClaimService {
    InsuranceClaim createInsuranceClaim(InsuranceClaim insuranceClaim);
    InsuranceClaim getInsuranceClaimById(Long id);
    List<InsuranceClaim> getAllInsuranceClaims();
    List<InsuranceClaim> findClaimsByStatus(String status);
    List<InsuranceClaim> findClaimsByPolicyId(Long policyId);
    List<InsuranceClaim> findClaimsAboveAmount(Double amount);
    void deleteInsuranceClaim(Long id);
}
