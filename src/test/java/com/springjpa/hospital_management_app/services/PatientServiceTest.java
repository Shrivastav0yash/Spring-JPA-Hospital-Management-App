package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.entity.Patient;
import com.springjpa.hospital_management_app.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientServiceTest {


    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testTransactionMethods(){

        /*
        Patient patient = patientService.getPatientById(1L);
        System.out.println(patient);
         */
        /*

        Patient patient  = patientRepository.findByName("Neha Gupta");
        System.out.println(patient);

        List<Patient> patientsList = patientRepository.findByBirthDateOrEmail(
                LocalDate.of(2001, 3, 18),
                "rahul.sharma@gmail.com"
        );

        for(Patient i : patientsList){
            System.out.println(i);
        }

         */
        List<Patient> patientsList = patientRepository.findByNameContainingOrderByIdDesc("n");

        for(Patient i : patientsList){
            System.out.println(i);
        }
    }
}
