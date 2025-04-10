package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle createVehicle(Vehicle vehicle);
    Optional<Vehicle> getVehicleById(Long id);
    List<Vehicle> getAllVehicles();
    List<Vehicle> findByMake(String make);
    List<Vehicle> findByModel(String model);
    List<Vehicle> findByCustomerId(Long customerId);
    List<Vehicle> findVehiclesNewerThan(int year);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
}
