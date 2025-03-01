package com.main.medibridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.medibridge.entities.Relation;

public interface RelationRepo extends JpaRepository<Relation,Long>{
    
}
