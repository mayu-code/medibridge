package com.main.medibridge.controller;

import java.util.Optional;

import javax.xml.crypto.Data;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.medibridge.Dto.DataReponse;
import com.main.medibridge.Dto.SuccessResponse;
import com.main.medibridge.entities.Request;

@RestController
@RequestMapping("/pathologist")
@CrossOrigin(origins = {"http://localhost:5173/","http://localhost:5174/"})
public class PathologistController {
    
    public ResponseEntity<DataReponse> pendingRequests(@RequestHeader("Authorization")String jwt){
        DataReponse response = new DataReponse();
        try{
             
            response.setMessage("pending request get successfully!");
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
