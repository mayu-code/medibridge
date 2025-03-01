package com.main.medibridge.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.medibridge.Repository.PatientRepo;
import com.main.medibridge.entities.Patient;
import com.main.medibridge.services.ServiceInterface.PatientService;

@Service
public class PatienctServiceImpl implements PatientService{

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public Patient addPatient(Patient patient) {
        return this.patientRepo.save(patient);
    }

    @Override
    public void deletePatient(long id) {
         this.patientRepo.deleteById(id);
         return;
    }

    @Override
    public Patient getPatientById(long id) {
        return this.patientRepo.findById(id).get();
    }

    @Override
    public Patient getPatientByEmail(String email) {
        return this.patientRepo.findByEmail(email);
    }
    
}
