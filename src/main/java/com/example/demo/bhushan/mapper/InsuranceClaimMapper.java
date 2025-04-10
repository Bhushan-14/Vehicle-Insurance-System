package com.example.demo.bhushan.mapper;

import com.example.demo.bhushan.dao.entities.InsuranceClaim;
import com.example.demo.bhushan.dto.InsuranceClaimDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {InsurancePolicyMapper.class})
public interface InsuranceClaimMapper {
    InsuranceClaimMapper INSTANCE = Mappers.getMapper(InsuranceClaimMapper.class);

    InsuranceClaimDTO toDTO(InsuranceClaim insuranceClaim);
    InsuranceClaim toEntity(InsuranceClaimDTO insuranceClaimDTO);
}
