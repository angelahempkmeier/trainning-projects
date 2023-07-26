package com.angieverse.bookie.repositories;

import com.angieverse.bookie.entities.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long> {

}
