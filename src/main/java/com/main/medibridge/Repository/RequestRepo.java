package com.main.medibridge.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.main.medibridge.entities.Request;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {


    @Query("SELECT r FROM Request r WHERE r.id = :id AND (:status IS NULL OR r.status = :status)")
    List<Request> getRequestsByPathologist(@Param("id")long id,@Param("status") String status);

    @Query("SELECT r FROM Request r WHERE r.id = :id AND (:status IS NULL OR r.status = :status)")
    List<Request> getRequestsByDoctor(@Param("id")long id,@Param("status") String status);
}
