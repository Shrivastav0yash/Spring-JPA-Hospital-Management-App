package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.dto.CreateAppointmentDTO;
import com.springjpa.hospital_management_app.dto.DoctorAppointmentsDTO;
import com.springjpa.hospital_management_app.entity.Appointment;
import com.springjpa.hospital_management_app.entity.Doctor;
import com.springjpa.hospital_management_app.entity.Patient;
import com.springjpa.hospital_management_app.repository.AppointmentRepository;
import com.springjpa.hospital_management_app.repository.DoctorRepository;
import com.springjpa.hospital_management_app.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void createNewAppointment(CreateAppointmentDTO appointmentDTO){
        Doctor doctor = doctorRepository.findById(appointmentDTO.getDoctorId()).orElseThrow();
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId()).orElseThrow();

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
        appointment.setReason(appointmentDTO.getReason());

        patient.getAppointments().add(appointment);
        appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); //this will automatically update because of dirty check
        doctor.getAppointments().add(appointment); //just for bidirectional consistency
        return appointment;
    }

    public List<DoctorAppointmentsDTO>  getAllAppointmentsOfDoctor(Long doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        List<Appointment> appointments = doctor.getAppointments();
        return appointments.stream().map(appointment -> modelMapper.map(appointment, DoctorAppointmentsDTO.class)).toList();
    }
}
