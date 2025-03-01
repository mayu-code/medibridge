package com.main.medibridge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.main.medibridge.entities.Report;
import com.main.medibridge.entities.Request;
import com.main.medibridge.entities.User;
import com.main.medibridge.services.impl.PatienctServiceImpl;
import com.main.medibridge.services.impl.RequestServiceImpl;
import com.main.medibridge.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/pathologist")
@CrossOrigin(origins = {"http://localhost:5173/","http://localhost:5174/"})
public class PathologistController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RequestServiceImpl requestServiceImpl;

    @Autowired
    private PatienctServiceImpl patienctServiceImpl;
    
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

    @PostMapping("/makeReport")
    public ResponseEntity<SuccessResponse> makeReport(@RequestBody Report report){
        SuccessResponse response = new SuccessResponse();
        Request request = this.requestServiceImpl.getRequestById(report.getRequestId());
        request.setStatus(RequestStatus.COMPLETED);
        this.requestServiceImpl.addRequest(request);
        try{
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

    @PostMapping("/acceptRequest/{requestId}")
    public ResponseEntity<SuccessResponse> acceptRequest(@PathVariable("requestId")long id){
        SuccessResponse response = new SuccessResponse();

        try{
            Request request = this.requestServiceImpl.getRequestById(id);
            request.setStatus(RequestStatus.ACCEPTED);
            this.requestServiceImpl.addRequest(request);

            Relation relation = new Relation();
            

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
