package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.InsurancePolicy;
import java.util.List;
import java.util.Optional;

public interface InsurancePolicyService {
    InsurancePolicy createPolicy(InsurancePolicy policy);
    Optional<InsurancePolicy> getPolicyById(Long id);
    List<InsurancePolicy> getAllPolicies();
    List<InsurancePolicy> findByCoverageType(String coverageType);
    List<InsurancePolicy> findActivePolicies();
    List<InsurancePolicy> findExpiringPolicies(int days);
    InsurancePolicy updatePolicy(Long id, InsurancePolicy policy);
    void deletePolicy(Long id);
}
