package com.springjpa.hospital_management_app.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DoctorAppointmentsDTO {

    private PatientNameDTO patientName;
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;


}
