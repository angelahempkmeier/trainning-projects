package com.angieverse.bookie.services;

import com.angieverse.bookie.entities.Reference;
import com.angieverse.bookie.entities.User;
import com.angieverse.bookie.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReferenceService {

    @Autowired
    private ReferenceRepository repository;

    public List<Reference> getAllReferences(){
        return repository.findAll();
    }

    public List<Reference> findByBook(String book){
        List<Reference> refs = new ArrayList<>();
        for(Reference reference : getAllReferences()){
            if(reference.getBook().equals(book)){
                refs.add(reference);
            }
        }
        return refs;
    }

    public List<Reference> findByKeyword(String keyword){
        List<Reference> refs = new ArrayList<>();
        for(Reference reference : getAllReferences()){
            if(reference.getKeyword().contains(keyword)){
                refs.add(reference);
            }
        }
        return refs;
    }

    public Reference insert(Reference reference){
        return repository.save(reference);
    }



}
