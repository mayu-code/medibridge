package com.main.medibridge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.medibridge.Dto.DataReponse;
import com.main.medibridge.entities.User;
import com.main.medibridge.services.impl.PatienctServiceImpl;
import com.main.medibridge.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:5173/","http://localhost:5174/"})
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PatienctServiceImpl patienctServiceImpl;
    
    @GetMapping("/getProfile")
    public ResponseEntity<DataReponse> getUserByJwt(@RequestHeader("Authorization")String jwt){
        DataReponse response = new DataReponse();
        try{
            response.setData(this.userServiceImpl.getUserByJwt(jwt));
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

    @GetMapping("/getPatients")
    public ResponseEntity<DataReponse> getPatients(@RequestHeader("Authorization")String jwt){
        DataReponse response = new DataReponse();
        User user = this.userServiceImpl.getUserByJwt(jwt);
        try{
            response.setData(this.patienctServiceImpl.getPatientById(user.getId()));
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
