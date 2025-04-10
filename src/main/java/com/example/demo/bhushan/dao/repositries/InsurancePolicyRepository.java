package com.example.demo.bhushan.dao.repositries;

import com.example.demo.bhushan.dao.entities.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.coverageType = :coverageType")
    List<InsurancePolicy> findByCoverageType(@Param("coverageType") String coverageType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.isActive = true")
    List<InsurancePolicy> findActivePolicies();

    @Query(value = "SELECT * FROM insurance_policy ip WHERE ip.expiry_date BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL :days DAY)", nativeQuery = true)
    List<InsurancePolicy> findExpiringPolicies(@Param("days") int days);
}
