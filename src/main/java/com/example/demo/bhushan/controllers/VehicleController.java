package com.example.demo.bhushan.controllers;

import com.example.demo.bhushan.dao.entities.Vehicle;
import com.example.demo.bhushan.dto.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/vehicles")
public interface VehicleController {

    @PostMapping("/create")
    ResponseEntity<ApiResponse<Vehicle>> createVehicle(@RequestBody Vehicle vehicle);

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<Optional<Vehicle>>> getVehicleById(@PathVariable Long id);

    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<Vehicle>>> getAllVehicles();

    @GetMapping("/make/{make}")
    ResponseEntity<ApiResponse<List<Vehicle>>> findByMake(@PathVariable String make);

    @GetMapping("/model/{model}")
    ResponseEntity<ApiResponse<List<Vehicle>>> findByModel(@PathVariable String model);

    @GetMapping("/customer/{customerId}")
    ResponseEntity<ApiResponse<List<Vehicle>>> findByCustomerId(@PathVariable Long customerId);

    @GetMapping("/newer-than/{year}")
    ResponseEntity<ApiResponse<List<Vehicle>>> findVehiclesNewerThan(@PathVariable int year);

    @PutMapping("/update/{id}")
    ResponseEntity<ApiResponse<Vehicle>> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle);

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deleteVehicle(@PathVariable Long id);
}
