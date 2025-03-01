package com.main.medibridge.services.ServiceInterface;

import com.main.medibridge.entities.Report;

public interface ReportService {
    Report addReport(Report report);
    Report getReportByid(long id);
    Report getReportByRequestId(long id);
}
