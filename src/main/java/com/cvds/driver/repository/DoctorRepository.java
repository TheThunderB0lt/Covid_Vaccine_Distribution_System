package com.cvds.driver.repository;

import com.cvds.driver.models.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    //this query is fetching records from the "doctor" table for a specific "vaccination_center_id" where the "patient_count" is the minimum among all records with the same "vaccination_center_id."
    @Query(value = "select * from doctor where vaccination_center_id=:vcid and patient_count = (select min(patient_count) from doctor where vaccination_center_id=:vcid)", nativeQuery = true)
    public List<Doctor> getMinimumDoctorOnTheBasisOfVC(UUID vcid);

    @Modifying
    @Transactional
    @Query(value = "update doctor set patient_count=:patientCount where id=:docId", nativeQuery = true)
    public void updatePatientCountByOne(UUID docId, int patientCount); //Updating patient_count+1 for doctor with particular docId

    @Modifying
    @Transactional  //Some kind of adding into our DB, like tranaction
    @Query(value = "insert into doctor_patients (doctor_id, patient_id) values (:doctorId, :patientId)", nativeQuery = true)
    public void insertIntoDoctorVsPatientTable(UUID doctorId, UUID patientId);
}
