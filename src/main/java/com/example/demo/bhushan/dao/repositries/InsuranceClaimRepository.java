package com.example.demo.bhushan.dao.repositries;

import com.example.demo.bhushan.dao.entities.InsuranceClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InsuranceClaimRepository extends JpaRepository<InsuranceClaim, Long> {

    @Query("SELECT ic FROM InsuranceClaim ic WHERE ic.status = :status")
    List<InsuranceClaim> findClaimsByStatus(@Param("status") String status);

    @Query("SELECT ic FROM InsuranceClaim ic WHERE ic.policy.id = :policyId")
    List<InsuranceClaim> findClaimsByPolicyId(@Param("policyId") Long policyId);

    @Query("SELECT ic FROM InsuranceClaim ic WHERE ic.claimAmount > :amount")
    List<InsuranceClaim> findClaimsAboveAmount(@Param("amount") Double amount);
}
