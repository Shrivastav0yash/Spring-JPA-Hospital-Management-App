package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.entity.Appointment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 2, 28, 10, 12, 21))
                .reason("Cancer")
                .build();

        Appointment newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);

        System.out.println(newAppointment);

        Appointment updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);

        System.out.println(updatedAppointment);

    }

}
