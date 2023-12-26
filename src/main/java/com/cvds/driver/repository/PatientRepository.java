package com.cvds.driver.repository;

import com.cvds.driver.models.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Query(value = "select * from patient where email=:patientEmail", nativeQuery = true)
    public Patient getPatientByEmail(String patientEmail);

    @Transactional
    @Modifying
    @Query(value = "update patient set dose_count=:count where id=:id", nativeQuery = true)
    public void updateDoseCountByOne(UUID id, int count);
}
