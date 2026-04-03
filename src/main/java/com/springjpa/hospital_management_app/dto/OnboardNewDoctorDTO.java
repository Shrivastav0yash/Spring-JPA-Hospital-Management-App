package com.springjpa.hospital_management_app.dto;

import lombok.Data;

@Data
public class OnboardNewDoctorDTO {
    private String specialization;
    private String name;
    private String email;
}
