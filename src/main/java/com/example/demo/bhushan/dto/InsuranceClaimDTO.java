package com.example.demo.bhushan.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class InsuranceClaimDTO {
    private Long id;
    private String claimNumber;
    private String status;
    private double claimAmount;
    private boolean active; 
    @JsonIgnoreProperties("claims")
    private InsurancePolicyDTO policy;
}
