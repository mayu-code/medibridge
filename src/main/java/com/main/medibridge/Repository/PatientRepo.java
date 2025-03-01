package com.main.medibridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.medibridge.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient,Long>{
    Patient findByEmail(String email);
}
