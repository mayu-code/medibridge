package com.main.medibridge.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.main.medibridge.entities.Patient;
import com.main.medibridge.entities.Report;
import com.main.medibridge.services.MailService;

import jakarta.transaction.Transactional;

@Component
public class MailFormater {

    @Autowired
    private  MailService mailService;

    @Transactional
    @Async("taskExecutor")
    public  void formatMail(Patient patient, Report report) {
        String emailBody = "Dear " + patient.getName() + ",\n\n" +
                "Your medical report is now available. Please find the details below:\n\n" +
                "🔹 **Patient Details:**\n" +
                "   - Name: " + patient.getName() + "\n" +
                "   - Age: " + patient.getAge() + "\n\n" +
                "🔹 **Test Results:**\n" +
                "   - Blood Group: " + report.getBloodGroup() + "\n" +
                "   - RBC Count: " + report.getRbcCount() + "\n" +
                "   - WBC Count: " + report.getWbcCount() + "\n" +
                "   - Hemoglobin (HB) Count: " + report.getHbCount() + "\n" +
                "   - Platelets: " + report.getPlatelets() + "\n\n" +
                "If you have any questions, please contact your healthcare provider.\n\n" +
                "Best regards,\n" +
                "Medibridge Team";

        this.mailService.sendMail(patient.getEmail(), "Your Medical Report is Completed", emailBody, false);
    }
}
