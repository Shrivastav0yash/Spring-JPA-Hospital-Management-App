package com.springjpa.hospital_management_app.repository;

import com.springjpa.hospital_management_app.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient>  findByNameContainingOrderByIdDesc(String name);

}
