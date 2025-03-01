package com.main.medibridge.services.impl;

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
    
}
