package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.InsuranceClaim;
import com.example.demo.bhushan.dao.repositries.InsuranceClaimRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class InsuranceClaimServiceImpl implements InsuranceClaimService {

    private final InsuranceClaimRepository insuranceClaimRepository;

    @Override
    public InsuranceClaim createInsuranceClaim(InsuranceClaim insuranceClaim) {
        log.info("Creating new insurance claim: {}", insuranceClaim);
        return insuranceClaimRepository.save(insuranceClaim);
    }

    @Override
    public InsuranceClaim getInsuranceClaimById(Long id) {
        log.info("Fetching insurance claim with ID: {}", id);
        return insuranceClaimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance Claim not found with ID: " + id));
    }

    @Override
    public List<InsuranceClaim> getAllInsuranceClaims() {
        log.info("Fetching all insurance claims");
        return insuranceClaimRepository.findAll();
    }

    @Override
    public List<InsuranceClaim> findClaimsByStatus(String status) {
        log.info("Fetching insurance claims with status: {}", status);
        return insuranceClaimRepository.findClaimsByStatus(status);
    }

    @Override
    public List<InsuranceClaim> findClaimsByPolicyId(Long policyId) {
        log.info("Fetching insurance claims for policy ID: {}", policyId);
        return insuranceClaimRepository.findClaimsByPolicyId(policyId);
    }

    @Override
    public List<InsuranceClaim> findClaimsAboveAmount(Double amount) {
        log.info("Fetching insurance claims above amount: {}", amount);
        return insuranceClaimRepository.findClaimsAboveAmount(amount);
    }

    @Override
    public void deleteInsuranceClaim(Long id) {
        log.info("Deleting insurance claim with ID: {}", id);
        InsuranceClaim claim = getInsuranceClaimById(id);
        insuranceClaimRepository.delete(claim);
    }
}
