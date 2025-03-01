package com.main.medibridge.entities;

import com.main.medibridge.Helper.RequestStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reqeustId;
    private long doctorId;
    private long patientId;
    private long pathologistId;
    private RequestStatus status;
    private String desease;
    private String symptoms;
}
