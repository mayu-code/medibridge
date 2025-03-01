package com.main.medibridge.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.medibridge.entities.Report;
import com.main.medibridge.entities.Request;

public interface ReportRepo extends JpaRepository<Report,Long>{

}
