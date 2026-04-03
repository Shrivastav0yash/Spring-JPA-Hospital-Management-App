package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.dto.PatientAppointmentResponseDTO;
import com.springjpa.hospital_management_app.dto.PatientResponseDTO;
import com.springjpa.hospital_management_app.entity.Patient;
import com.springjpa.hospital_management_app.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public List<PatientResponseDTO> getAll(){
        List<Patient> allPatients = patientRepository.findAll();
        return allPatients.stream().map(patient -> modelMapper.map(patient, PatientResponseDTO.class)).toList();
    }

    public PatientAppointmentResponseDTO getPatientById(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not " +
                "Found with id: " + patientId));
        return modelMapper.map(patient,PatientAppointmentResponseDTO.class);
    }
}
