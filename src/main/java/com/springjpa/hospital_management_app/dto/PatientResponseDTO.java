package com.springjpa.hospital_management_app.dto;

import com.springjpa.hospital_management_app.entity.Insurance;
import com.springjpa.hospital_management_app.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDTO {
    private Long id;
    private String name ;
    private String email;
    private String gender;
    private LocalDate birthDate;
    private BloodGroupType bloodGroup;
    private Insurance insurance;
}
