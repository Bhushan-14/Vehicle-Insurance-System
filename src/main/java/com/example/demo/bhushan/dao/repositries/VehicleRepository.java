package com.example.demo.bhushan.dao.repositries;

import com.example.demo.bhushan.dao.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.make = :make")
    List<Vehicle> findByMake(@Param("make") String make);

    @Query("SELECT v FROM Vehicle v WHERE v.model = :model")
    List<Vehicle> findByModel(@Param("model") String model);

    @Query("SELECT v FROM Vehicle v WHERE v.customer.id = :customerId") 
    List<Vehicle> findByCustomerId(@Param("customerId") Long customerId); 

    @Query("SELECT v FROM Vehicle v WHERE v.manufactureYear > :year")
    List<Vehicle> findVehiclesNewerThan(@Param("year") int year);
}
