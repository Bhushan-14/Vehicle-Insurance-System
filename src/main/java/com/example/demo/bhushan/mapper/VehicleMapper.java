package com.example.demo.bhushan.mapper;

import com.example.demo.bhushan.dao.entities.Vehicle;
import com.example.demo.bhushan.dto.VehicleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    VehicleDTO toDTO(Vehicle vehicle);
    Vehicle toEntity(VehicleDTO vehicleDTO);
}
