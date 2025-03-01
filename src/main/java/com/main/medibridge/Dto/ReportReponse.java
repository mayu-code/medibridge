package com.main.medibridge.Dto;

import lombok.Data;

@Data
public class ReportReponse {
    private long id;
    private long requestId;
    private String rbcCount;
    private String wbcCount;
    private String hbCount;
    private String bloodGroup;
    private String platelets;
    private String doctorName;
    private String patientName;
}
