package com.example.demo.bhushan.queryBuilder;

import com.example.demo.bhushan.dao.entities.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class VehicleCriteriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findVehiclesByMake(String make) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> query = cb.createQuery(Vehicle.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        query.select(root).where(cb.equal(root.get("make"), make));
        return entityManager.createQuery(query).getResultList();
    }
}
