package com.example.demo.bhushan.mapper;

import com.example.demo.bhushan.dao.entities.InsurancePolicy;
import com.example.demo.bhushan.dto.InsurancePolicyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CustomerMapper.class, VehicleMapper.class, InsuranceClaimMapper.class})
public interface InsurancePolicyMapper {
    InsurancePolicyMapper INSTANCE = Mappers.getMapper(InsurancePolicyMapper.class);

    InsurancePolicyDTO toDTO(InsurancePolicy insurancePolicy);
    InsurancePolicy toEntity(InsurancePolicyDTO insurancePolicyDTO);
}
