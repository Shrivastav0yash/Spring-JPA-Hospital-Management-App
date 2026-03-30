package com.springjpa.hospital_management_app.repository;

import com.springjpa.hospital_management_app.dto.BloodGroupCountResponseEntity;
import com.springjpa.hospital_management_app.entity.Patient;
import com.springjpa.hospital_management_app.entity.type.BloodGroupType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient>  findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate < :birthDate")
    List<Patient> findByBirthDateBefore(@Param("birthDate") LocalDate birthDate);

    @Query("select new com.springjpa.hospital_management_app.dto.BloodGroupCountResponseEntity( p.bloodGroup, Count(p))" +
            " from Patient p group by p.bloodGroup")
    //List<Object[]> countByBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType(); //this is projection of Data

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);


    @Transactional
    @Modifying
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameById(@Param("name") String name, @Param("id") Long id);

    @Query("SELECT p  FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    //@Query("SELECT p  FROM Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> findAllPatientWithAppointment();

}
