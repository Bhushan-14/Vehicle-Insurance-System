package com.example.demo.bhushan.queryBuilder;

import com.example.demo.bhushan.dao.entities.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AdminCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Admin> findAdminsByRole(String role) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Admin> query = cb.createQuery(Admin.class);
        Root<Admin> root = query.from(Admin.class);
        query.select(root).where(cb.equal(root.get("role"), role));
        return entityManager.createQuery(query).getResultList();
    }
}
