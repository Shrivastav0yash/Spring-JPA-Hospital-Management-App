package com.springjpa.hospital_management_app.repository;

import com.springjpa.hospital_management_app.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatientRepository(){
        List<Patient> patientsList = patientRepository.findAll();
        System.out.println(patientsList);
    }
}
