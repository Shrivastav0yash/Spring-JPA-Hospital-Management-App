package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.entity.Insurance;
import com.springjpa.hospital_management_app.entity.Patient;
import com.springjpa.hospital_management_app.repository.InsuranceRepository;
import com.springjpa.hospital_management_app.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: "+patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bidirectional consistency maintain

        return patient;

    }

    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
        patient.setInsurance(null);
        return patient;
    }

}
