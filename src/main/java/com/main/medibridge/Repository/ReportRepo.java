package com.main.medibridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.medibridge.entities.Report;

public interface ReportRepo extends JpaRepository<Report,Long>{

}
