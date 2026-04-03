package com.springjpa.hospital_management_app.controller;

import com.springjpa.hospital_management_app.dto.DoctorResponseDTO;
import com.springjpa.hospital_management_app.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final DoctorService doctorService;

    @GetMapping("all-doctors")
    public ResponseEntity<List<DoctorResponseDTO>> allDoctorsInHospital(){
        List<DoctorResponseDTO> allDoctor = doctorService.getAllDoctor();
        return new ResponseEntity<>(allDoctor, HttpStatus.OK);
    }
}
