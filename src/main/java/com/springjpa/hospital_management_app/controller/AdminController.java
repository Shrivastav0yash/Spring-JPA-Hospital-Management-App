package com.springjpa.hospital_management_app.controller;

import com.springjpa.hospital_management_app.dto.OnboardNewDoctorDTO;
import com.springjpa.hospital_management_app.dto.PatientResponseDTO;
import com.springjpa.hospital_management_app.services.DoctorService;
import com.springjpa.hospital_management_app.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping("/All-OK")
    public ResponseEntity<?> healthCheck(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all-patients")
    public ResponseEntity<?> getAlPatients(){
        List<PatientResponseDTO> all = patientService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping("onboardNewDoctor")
    public ResponseEntity<?> onboardNewDoctor(@RequestBody OnboardNewDoctorDTO onboardNewDoctor){
        doctorService.onboardDoctor(onboardNewDoctor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
