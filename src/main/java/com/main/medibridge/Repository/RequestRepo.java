package com.main.medibridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.medibridge.entities.Request;

public interface RequestRepo extends JpaRepository<Request,Long>{
    
}
