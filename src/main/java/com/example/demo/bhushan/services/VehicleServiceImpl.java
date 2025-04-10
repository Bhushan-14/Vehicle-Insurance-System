package com.example.demo.bhushan.services;

import com.example.demo.bhushan.dao.entities.Vehicle;
import com.example.demo.bhushan.dao.repositries.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleServiceImpl.class);
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        logger.info("Creating new vehicle: {}", vehicle);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        logger.info("Fetching vehicle with ID: {}", id);
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        logger.info("Fetching all vehicles");
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> findByMake(String make) {
        logger.info("Fetching vehicles by make: {}", make);
        return vehicleRepository.findByMake(make);
    }

    @Override
    public List<Vehicle> findByModel(String model) {
        logger.info("Fetching vehicles by model: {}", model);
        return vehicleRepository.findByModel(model);
    }

    @Override
    public List<Vehicle> findByCustomerId(Long customerId) {
        logger.info("Fetching vehicles by customer ID: {}", customerId);
        return vehicleRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Vehicle> findVehiclesNewerThan(int year) {
        logger.info("Fetching vehicles newer than year: {}", year);
        return vehicleRepository.findVehiclesNewerThan(year);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        logger.info("Updating vehicle with ID: {}", id);
        return vehicleRepository.findById(id).map(vehicle -> {
            vehicle.setMake(updatedVehicle.getMake());
            vehicle.setModel(updatedVehicle.getModel());
            vehicle.setManufactureYear(updatedVehicle.getManufactureYear());
            vehicle.setCustomer(updatedVehicle.getCustomer()); 
            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + id));
    }

    @Override
    public void deleteVehicle(Long id) {
        logger.info("Deleting vehicle with ID: {}", id);
        vehicleRepository.deleteById(id);
    }
}
