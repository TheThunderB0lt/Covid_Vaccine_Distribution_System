package com.cvds.driver.repository;

import com.cvds.driver.models.VaccinationCenter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, UUID> {

    @Query(value = "select * from vaccination_center where doctor_count = (select min(doctor_count) from vaccination_center)", nativeQuery = true)
    public List<VaccinationCenter> getMinDoctorVaccinationCenter();

    @Query(value = "select * from vaccination_center where type=:type and covaxin_count != 0", nativeQuery = true)
    public List<VaccinationCenter> getAllVCOnTheBasisOfTypeAndCovaxinCount(String type);

    @Query(value = "select * from vaccination_center where type=:type and covishield_count != 0", nativeQuery = true)
    public List<VaccinationCenter> getAllVCOnTheBasisOfTypeAndCovishieldinCount(String type);

    @Query(value = "select * from vaccination_center where type=:type and sputnik_count != 0", nativeQuery = true)
    public List<VaccinationCenter> getAllVCOnTheBasisOfTypeAndSputnikinCount(String type);

    @Modifying
    @Transactional
    @Query(value = "UPDATE vaccination_center SET doctor_count=:docCount WHERE id=:id", nativeQuery = true)
    public void updateDocCountByOne(UUID id, int docCount);
}
