package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.Vehicle;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import com.example.demo.bhushan.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleControllerImpl implements VehicleController {

    private final VehicleService vehicleService;

    public VehicleControllerImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public ResponseEntity<ApiResponse<Vehicle>> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(ApiResponse.success(savedVehicle, "Vehicle created successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<Optional<Vehicle>>> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(ApiResponse.success(vehicle, "Vehicle fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Vehicle>>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(ApiResponse.success(vehicles, "All vehicles fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Vehicle>>> findByMake(@PathVariable String make) {
        List<Vehicle> vehicles = vehicleService.findByMake(make);
        return ResponseEntity.ok(ApiResponse.success(vehicles, "Vehicles by make fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Vehicle>>> findByModel(@PathVariable String model) {
        List<Vehicle> vehicles = vehicleService.findByModel(model);
        return ResponseEntity.ok(ApiResponse.success(vehicles, "Vehicles by model fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Vehicle>>> findByCustomerId(@PathVariable Long customerId) {
        List<Vehicle> vehicles = vehicleService.findByCustomerId(customerId);
        return ResponseEntity.ok(ApiResponse.success(vehicles, "Vehicles by customer ID fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<Vehicle>>> findVehiclesNewerThan(@PathVariable int year) {
        List<Vehicle> vehicles = vehicleService.findVehiclesNewerThan(year);
        return ResponseEntity.ok(ApiResponse.success(vehicles, "Vehicles newer than " + year + " fetched successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<Vehicle>> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);
        return ResponseEntity.ok(ApiResponse.success(updatedVehicle, "Vehicle updated successfully"));
    }

    @Override
    public ResponseEntity<ApiResponse<String>> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok(ApiResponse.success("Vehicle deleted successfully", "Success"));
    }
}
