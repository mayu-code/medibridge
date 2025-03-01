package com.main.medibridge.services.impl;

import org.springframework.stereotype.Service;

import com.main.medibridge.Repository.ReportRepo;
import com.main.medibridge.entities.Report;
import com.main.medibridge.services.ServiceInterface.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

    private ReportRepo reportRepo;

    @Override
    public Report addReport(Report report) {
        return this.reportRepo.save(report);
    }

    @Override
    public Report getReportByid(long id) {
        return this.reportRepo.findById(id).get();
    }

    @Override
    public Report getReportByRequestId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReportByRequestId'");
    }
    
}
