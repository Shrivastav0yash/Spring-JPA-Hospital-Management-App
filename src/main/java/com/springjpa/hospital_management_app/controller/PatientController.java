package com.springjpa.hospital_management_app.controller;


import com.springjpa.hospital_management_app.dto.PatientAppointmentResponseDTO;
import com.springjpa.hospital_management_app.services.AppointmentService;
import com.springjpa.hospital_management_app.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PutMapping("/create-Appointment")
    public ResponseEntity<?> createNewAppointment(){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileAndAllAppointments(@PathVariable Long id){
        PatientAppointmentResponseDTO profile = patientService.getPatientById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }
}
