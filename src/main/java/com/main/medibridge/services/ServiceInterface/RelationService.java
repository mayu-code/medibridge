package com.main.medibridge.services.ServiceInterface;

import java.util.List;

import com.main.medibridge.entities.Relation;

public interface RelationService {
    Relation addRelation(Relation relation);
    List<Long> getAllPatientsIdByUser(long id);
}
