package com.main.medibridge.Dto;

import com.main.medibridge.Helper.RequestStatus;
import com.main.medibridge.entities.User;

import lombok.Data;

@Data
public class RequestResponse {
    private long reqeustId;
    private RequestStatus status;
    private String desease;
    private String symptoms;
    private User pathologist;
    private User doctor;
    private com.main.medibridge.entities.Patient Patient;
}
