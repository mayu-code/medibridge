package com.main.medibridge.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.medibridge.Repository.RequestRepo;
import com.main.medibridge.entities.Request;
import com.main.medibridge.services.ServiceInterface.RequestService;

@Service
public class RequestServiceImpl implements RequestService{

    @Autowired
    private RequestRepo requestRepo;

    @Override
    public Request addRequest(Request request) {
        return this.requestRepo.save(request);
    }

    @Override
    public List<Request> getRequestsByPathologist(long id, String status) {
        return this.requestRepo.getRequestsByPathologist(id, status);
    }

    @Override
    public List<Request> getRequestsByDoctor(long id, String status) {
        return this.requestRepo.getRequestsByDoctor(id, status);
    }
    
}
