package com.springjpa.hospital_management_app.controller;

import com.springjpa.hospital_management_app.dto.DoctorAppointmentsDTO;
import com.springjpa.hospital_management_app.services.AppointmentService;
import com.springjpa.hospital_management_app.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    @GetMapping("/{doctorId}/appointments")
    public ResponseEntity<List<DoctorAppointmentsDTO>> allAppointments(@PathVariable Long doctorId){
        List<DoctorAppointmentsDTO> allAppointments = appointmentService.getAllAppointmentsOfDoctor(doctorId);
        return new ResponseEntity<>(allAppointments,HttpStatus.OK);
    }

}
