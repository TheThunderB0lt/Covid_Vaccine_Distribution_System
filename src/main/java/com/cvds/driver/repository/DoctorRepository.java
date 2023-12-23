package com.cvds.driver.repository;

import com.cvds.driver.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    @Query(value = "select * from doctor where vaccination_center_id=:vcid and patient_count = (select min(patient_count) from doctor where vaccination_center_id=:vcid)", nativeQuery = true)
    public List<Doctor> getMinimumDoctorOnTheBasisOfVC(UUID vcid);

}
