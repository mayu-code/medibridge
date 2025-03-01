package com.main.medibridge.services.ServiceInterface;

import java.util.List;

import com.main.medibridge.entities.Request;

public interface RequestService {
    Request addRequest(Request request);
    Request getRequestById(long id);


    List<Request> getRequestsByPathologist(long id,String status);
    List<Request> getRequestsByDoctor(long id,String status);

}
