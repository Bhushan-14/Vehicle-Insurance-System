package com.example.demo.bhushan.queryBuilder;

import com.example.demo.bhushan.dao.entities.InsuranceClaim;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class InsuranceClaimCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<InsuranceClaim> findClaimsByStatus(String status) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<InsuranceClaim> query = cb.createQuery(InsuranceClaim.class);
        Root<InsuranceClaim> root = query.from(InsuranceClaim.class);
        query.select(root).where(cb.equal(root.get("status"), status));
        return entityManager.createQuery(query).getResultList();
    }
}
