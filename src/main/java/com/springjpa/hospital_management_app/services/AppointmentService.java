package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.entity.Appointment;
import com.springjpa.hospital_management_app.entity.Doctor;
import com.springjpa.hospital_management_app.entity.Patient;
import com.springjpa.hospital_management_app.repository.AppointmentRepository;
import com.springjpa.hospital_management_app.repository.DoctorRepository;
import com.springjpa.hospital_management_app.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);//maintain consistency

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); //this will automatically update because of dirty check
        doctor.getAppointments().add(appointment); //just for bidirectional consistency
        return appointment;
    }
}
