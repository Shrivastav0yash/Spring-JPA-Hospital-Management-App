package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.dto.BloodGroupCountResponseEntity;
import com.springjpa.hospital_management_app.entity.Patient;
import com.springjpa.hospital_management_app.entity.type.BloodGroupType;
import com.springjpa.hospital_management_app.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientServiceTest {


    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testTransactionMethods() {

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


        List<Patient> patientsList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

        for(Patient i : patientsList){
            System.out.println(i);
        }



      //  List<Patient> patientsList = patientRepository.findByBirthDateBefore(LocalDate.of(2005, 9, 15));

         */
        Page<Patient> patientsList = patientRepository.findAllPatients(PageRequest.of(0,2, Sort.by("name")));
        for (Patient i : patientsList) {
            System.out.println(i);
        }





//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponseEntity : bloodGroupList){
//            System.out.println(bloodGroupCountResponseEntity);
//        }

//        int rowsUpdated = patientRepository.updateNameById("Priyanka Sharma", 2L);
//        System.out.println(rowsUpdated);

    }
}
