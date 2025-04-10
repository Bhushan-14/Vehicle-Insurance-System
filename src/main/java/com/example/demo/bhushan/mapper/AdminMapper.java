package com.example.demo.bhushan.mapper;

import com.example.demo.bhushan.dao.entities.Admin;
import com.example.demo.bhushan.dto.AdminDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDTO toDTO(Admin admin);
    Admin toEntity(AdminDTO adminDTO);
}
