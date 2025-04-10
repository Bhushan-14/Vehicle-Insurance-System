package com.example.demo.bhushan.queryBuilder;

import com.example.demo.bhushan.dao.entities.InsurancePolicy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class InsurancePolicyCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<InsurancePolicy> findPoliciesByCoverageType(String coverageType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InsurancePolicy> query = cb.createQuery(InsurancePolicy.class);
        Root<InsurancePolicy> root = query.from(InsurancePolicy.class);
        query.select(root).where(cb.equal(root.get("coverageType"), coverageType));
        return entityManager.createQuery(query).getResultList();
    }
}
