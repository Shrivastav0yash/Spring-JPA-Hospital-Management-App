package com.springjpa.hospital_management_app.repository;

import com.springjpa.hospital_management_app.entity.Appointment;
import com.springjpa.hospital_management_app.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public void testPatientRepository(){
        //List<Patient> patientsList = patientRepository.findAll();
        List<Patient> patientsList  = patientRepository.findAllPatientWithAppointment();
        assertNotNull(patientsList);
        assertFalse(patientsList.isEmpty());

        for (Patient patient : patientsList) {
            System.out.println("Patient ID: " + patient.getId());
            System.out.println("Name: " + patient.getName());
            System.out.println("Email: " + patient.getEmail());
            System.out.println("Blood Group: " + patient.getBloodGroup());

            for (Appointment appointment : patient.getAppointments()) {
                System.out.println("  Appointment ID: " + appointment.getId());
                System.out.println("  Time: " + appointment.getAppointmentTime());
                System.out.println("  Reason: " + appointment.getReason());

                if (appointment.getDoctor() != null) {
                    System.out.println("  Doctor: " + appointment.getDoctor().getName());
                    System.out.println("  Specialization: " + appointment.getDoctor().getSpecialization());
                    System.out.println("  Doctor Email: " + appointment.getDoctor().getEmail());
                }

                System.out.println("  ----------------------");
            }

            System.out.println("==================================");
        }
    }
}
