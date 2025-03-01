package com.main.medibridge.services.ServiceInterface;

import java.util.List;

import com.main.medibridge.Dto.RequestResponse;
import com.main.medibridge.entities.Request;

public interface RequestService {
    Request addRequest(Request request);
    Request getRequestById(long id);


    List<RequestResponse> getRequestsByPathologist(long id,String status);
    List<RequestResponse> getRequestsByDoctor(long id,String status);

}
