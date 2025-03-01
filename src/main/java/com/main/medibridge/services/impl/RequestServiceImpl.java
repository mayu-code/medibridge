package com.main.medibridge.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.medibridge.Dto.RequestResponse;
import com.main.medibridge.Repository.RequestRepo;
import com.main.medibridge.entities.Request;
import com.main.medibridge.services.ServiceInterface.RequestService;

@Service
public class RequestServiceImpl implements RequestService{

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private PatienctServiceImpl patienctServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public Request addRequest(Request request) {
        return this.requestRepo.save(request);
    }

    @Override
    public List<RequestResponse> getRequestsByPathologist(long id, String status) {
        List<Request> requests = this.requestRepo.getRequestsByPathologist(id, status);
        List<RequestResponse> responses = new ArrayList<>();
        for(Request request:requests){
            RequestResponse response = new RequestResponse();
            response.setDesease(request.getDesease());
            response.setSymptoms(request.getSymptoms());
            response.setReqeustId(request.getReqeustId());
            response.setStatus(request.getStatus());
            response.setDoctor(this.userServiceImpl.getUserById(request.getDoctorId()));
            response.setPatient(this.patienctServiceImpl.getPatientById(request.getPatientId()));
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<RequestResponse> getRequestsByDoctor(long id, String status) {
        List<Request> requests = this.requestRepo.getRequestsByPathologist(id, status);
        List<RequestResponse> responses = new ArrayList<>();
        for(Request request:requests){
            RequestResponse response = new RequestResponse();
            response.setDesease(request.getDesease());
            response.setSymptoms(request.getSymptoms());
            response.setReqeustId(request.getReqeustId());
            response.setStatus(request.getStatus());
            response.setPathologist(this.userServiceImpl.getUserById(request.getPathologistId()));
            response.setPatient(this.patienctServiceImpl.getPatientById(request.getPatientId()));
            responses.add(response);
        }
        return responses;
    }

    @Override
    public Request getRequestById(long id) {
        return this.requestRepo.findById(id).get();
    }
    
}
