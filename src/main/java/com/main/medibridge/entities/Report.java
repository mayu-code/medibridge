package com.main.medibridge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Report {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long requestId;
    private String rbcCount;
    private String wbcCount;
    private String hbCount;
    private String bloodGroup;
    private String platelets;
}
