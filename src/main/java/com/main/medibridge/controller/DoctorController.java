package com.main.medibridge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.medibridge.Dto.DataReponse;
import com.main.medibridge.Dto.SuccessResponse;
import com.main.medibridge.Helper.RequestStatus;
import com.main.medibridge.entities.Patient;
import com.main.medibridge.entities.Relation;
import com.main.medibridge.entities.Request;
import com.main.medibridge.entities.User;
import com.main.medibridge.services.impl.PatienctServiceImpl;
import com.main.medibridge.services.impl.RelationServiceImpl;
import com.main.medibridge.services.impl.RequestServiceImpl;
import com.main.medibridge.services.impl.UserServiceImpl;

import lombok.Data;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = {"http://localhost:5173/","http://localhost:5174/"})
public class DoctorController {
    
    @Autowired
    private PatienctServiceImpl patienctServiceImpl;

    @Autowired
    private RequestServiceImpl requestServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RelationServiceImpl relationServiceImpl;

    @PostMapping("/addPatient")
    public ResponseEntity<SuccessResponse> addPatient(@RequestHeader("Authorization")String jwt, @RequestBody Patient patient){
        SuccessResponse response = new SuccessResponse();
        User user = this.userServiceImpl.getUserByJwt(jwt);
        try{
            Patient patient2 = this.patienctServiceImpl.getPatientByEmail(patient.getEmail());
            if(patient2!=null){
                response.setMessage("patient Alredy present !");
                response.setStatus(HttpStatus.ALREADY_REPORTED);
                response.setStatusCode(208);
                return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(response);
            }
           patient =  this.patienctServiceImpl.addPatient(patient);

           Relation relation = new Relation();
           relation.setPatientId(patient.getId());
           relation.setUserId(user.getId());
            this.relationServiceImpl.addRelation(relation);

            response.setMessage("patient added successfully!");
            response.setStatus(HttpStatus.OK);
            response.setStatusCode(200);
            return ResponseEntity.of(Optional.of(response));
        }catch(Exception e){
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setStatusCode(500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/sendRequest")
    public ResponseEntity<SuccessResponse> sendRequest(@RequestBody Request request){
        SuccessResponse response = new SuccessResponse();
        try{
            request.setStatus(RequestStatus.PENDING);
            this.requestServiceImpl.addRequest(request);  
            response.setMessage("request sended successfully!");
            response.setStatus(HttpStatus.OK);
            response.setStatusCode(200);
            return ResponseEntity.of(Optional.of(response));
        }catch(Exception e){
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setStatusCode(500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/getAllRequests")
    public ResponseEntity<DataReponse> getRequests(@RequestHeader("Authorization")String jwt,@RequestParam(required = false) String status){
        DataReponse response = new DataReponse();
        User user = this.userServiceImpl.getUserByJwt(jwt);
        try{
             response.setData(this.requestServiceImpl.getRequestsByPathologist(user.getId(), status));
            response.setMessage("request get successfully!");
            response.setStatus(HttpStatus.OK);
            response.setStatusCode(200);
            return ResponseEntity.of(Optional.of(response));
        }catch(Exception e){
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setStatusCode(500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
