package com.main.medibridge.services.ServiceInterface;

import com.main.medibridge.entities.Patient;

public interface PatientService {
    Patient addPatient(Patient patient);
    void deletePatient(long id);
    Patient getPatientById(long id);
    Patient getPatientByEmail(String email);
}
