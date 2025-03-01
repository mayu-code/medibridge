package com.main.medibridge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.medibridge.Dto.SuccessResponse;
import com.main.medibridge.entities.Patient;
import com.main.medibridge.services.impl.PatienctServiceImpl;

import lombok.Data;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = {"http://localhost:5173/","http://localhost:5174/"})
public class DoctorController {
    
    @Autowired
    private PatienctServiceImpl patienctServiceImpl;

    @PostMapping("/addPatient")
    public ResponseEntity<SuccessResponse> addPatient(@RequestBody Patient patient){
        SuccessResponse response = new SuccessResponse();
        try{
            Patient patient2 = this.patienctServiceImpl.getPatientByEmail(patient.getEmail());
            if(patient2==null){
                response.setMessage("patient Alredy present !");
                response.setStatus(HttpStatus.ALREADY_REPORTED);
                response.setStatusCode(208);
                return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(response);
            }
            this.patienctServiceImpl.addPatient(patient);
            response.setMessage("patient added successfully!");
            response.setStatus(HttpStatus.OK);
            response.setStatusCode(208);
            return ResponseEntity.of(Optional.of(response));
        }catch(Exception e){
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setStatusCode(208);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
