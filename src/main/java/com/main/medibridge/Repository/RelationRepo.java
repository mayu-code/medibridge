package com.main.medibridge.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.main.medibridge.entities.Relation;

public interface RelationRepo extends JpaRepository<Relation,Long>{
    
    @Query("SELECT u.patientId FROM Relation u WHERE u.userId = :id")
    List<Long> findByUserId(@Param("id") long id);

}
