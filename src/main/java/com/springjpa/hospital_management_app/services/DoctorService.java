package com.springjpa.hospital_management_app.services;

import com.springjpa.hospital_management_app.dto.DoctorResponseDTO;
import com.springjpa.hospital_management_app.dto.OnboardNewDoctorDTO;
import com.springjpa.hospital_management_app.entity.Doctor;
import com.springjpa.hospital_management_app.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public List<DoctorResponseDTO> getAllDoctor(){
        List<Doctor> alldoctors = doctorRepository.findAll();
        return alldoctors.stream().map(doctor-> modelMapper.map(doctor,DoctorResponseDTO.class)).toList();
    }

    public void onboardDoctor(OnboardNewDoctorDTO newDoctor){

        if(doctorRepository.existsByNameAndEmail(newDoctor.getName(), newDoctor.getEmail())){
            throw new IllegalArgumentException("Already doctor exist in Hospital");
        }

        Doctor doctor = new Doctor();
        doctor.setName(newDoctor.getName());
        doctor.setEmail(newDoctor.getEmail());
        doctor.setSpecialization(newDoctor.getSpecialization());

        doctorRepository.save(doctor);

    }


}
