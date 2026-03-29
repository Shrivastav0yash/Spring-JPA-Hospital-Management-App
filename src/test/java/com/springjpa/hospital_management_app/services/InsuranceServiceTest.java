package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.entity.Insurance;
import com.springjpa.hospital_management_app.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceServiceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){

        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_12334")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);


    }
}
