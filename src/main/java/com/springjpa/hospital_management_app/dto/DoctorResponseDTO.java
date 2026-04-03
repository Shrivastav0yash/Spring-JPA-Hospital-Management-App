package com.springjpa.hospital_management_app.dto;

import lombok.Data;

@Data
public class DoctorResponseDTO {
    private Long id;
    private DoctorNameResponseDTO doctorName;
    private String email;
    private String specialization;
}
