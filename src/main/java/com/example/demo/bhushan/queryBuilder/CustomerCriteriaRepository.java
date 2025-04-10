package com.example.demo.bhushan.queryBuilder;

import com.example.demo.bhushan.dao.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> findCustomersByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);
        query.select(root).where(cb.like(root.get("name"), "%" + name + "%"));
        return entityManager.createQuery(query).getResultList();
    }
}
