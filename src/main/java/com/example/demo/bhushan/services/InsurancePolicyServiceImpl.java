package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.InsurancePolicy;
import com.example.demo.bhushan.dao.repositries.InsurancePolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    private static final Logger logger = LoggerFactory.getLogger(InsurancePolicyServiceImpl.class);
    private final InsurancePolicyRepository policyRepository;

    @Autowired
    public InsurancePolicyServiceImpl(InsurancePolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        logger.info("Creating new insurance policy: {}", policy);
        return policyRepository.save(policy);
    }

    @Override
    public Optional<InsurancePolicy> getPolicyById(Long id) {
        logger.info("Fetching policy with ID: {}", id);
        return policyRepository.findById(id);
    }

    @Override
    public List<InsurancePolicy> getAllPolicies() {
        logger.info("Fetching all insurance policies");
        return policyRepository.findAll();
    }

    @Override
    public List<InsurancePolicy> findByCoverageType(String coverageType) {
        logger.info("Fetching policies by coverage type: {}", coverageType);
        return policyRepository.findByCoverageType(coverageType);
    }

    @Override
    public List<InsurancePolicy> findActivePolicies() {
        logger.info("Fetching active insurance policies");
        return policyRepository.findActivePolicies();
    }

    @Override
    public List<InsurancePolicy> findExpiringPolicies(int days) {
        logger.info("Fetching policies expiring in {} days", days);
        return policyRepository.findExpiringPolicies(days);
    }

    @Override
    public InsurancePolicy updatePolicy(Long id, InsurancePolicy updatedPolicy) {
        logger.info("Updating policy with ID: {}", id);
        return policyRepository.findById(id).map(policy -> {
            policy.setCoverageType(updatedPolicy.getCoverageType());  // ✅ Updated this line
            policy.setPremiumAmount(updatedPolicy.getPremiumAmount());
            policy.setExpiryDate(updatedPolicy.getExpiryDate());
            policy.setActive(updatedPolicy.isActive());
            return policyRepository.save(policy);
        }).orElseThrow(() -> new RuntimeException("Policy not found with ID: " + id));
    }

    @Override
    public void deletePolicy(Long id) {
        logger.info("Deleting policy with ID: {}", id);
        policyRepository.deleteById(id);
    }
}
