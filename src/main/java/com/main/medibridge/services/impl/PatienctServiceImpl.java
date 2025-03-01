package com.main.medibridge.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.medibridge.Repository.PatientRepo;
import com.main.medibridge.Repository.RelationRepo;
import com.main.medibridge.entities.Patient;
import com.main.medibridge.services.ServiceInterface.PatientService;

@Service
public class PatienctServiceImpl implements PatientService{

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private RelationRepo relationRepo;

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

    @Override
    public List<Patient> getPatientbyUserId(long id) {
        List<Long> ids = this.relationRepo.findByUserId(id);
        List<Patient> patients = new ArrayList<>();
        for(Long id1:ids){
            patients.add(this.patientRepo.findById(id1).get());
        }
        return patients;
    }
    
}
