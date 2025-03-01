package com.main.medibridge.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.medibridge.Repository.RelationRepo;
import com.main.medibridge.entities.Relation;
import com.main.medibridge.services.ServiceInterface.RelationService;

@Service
public class RelationServiceImpl implements RelationService{

    @Autowired
    private RelationRepo relationRepo;

    @Override
    public Relation addRelation(Relation relation) {
        return this.relationRepo.save(relation);
    }

    @Override
    public List<Long> getAllPatientsIdByUser(long id) {
        return null;
    }
    
}
