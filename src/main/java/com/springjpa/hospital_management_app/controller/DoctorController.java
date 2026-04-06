package com.springjpa.hospital_management_app.controller;

import com.springjpa.hospital_management_app.dto.DoctorAppointmentsDTO;
import com.springjpa.hospital_management_app.entity.User;
import com.springjpa.hospital_management_app.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<DoctorAppointmentsDTO>> allAppointments(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<DoctorAppointmentsDTO> allAppointments = appointmentService.getAllAppointmentsOfDoctor(user.getId());
        return new ResponseEntity<>(allAppointments,HttpStatus.OK);
    }

}
