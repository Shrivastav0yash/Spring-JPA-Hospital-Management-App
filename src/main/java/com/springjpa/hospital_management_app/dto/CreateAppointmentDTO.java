package com.springjpa.hospital_management_app.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentDTO {
    private Long doctorId;
    private Long patientId;
    private LocalDateTime appointmentTime;
    private String reason;

}
