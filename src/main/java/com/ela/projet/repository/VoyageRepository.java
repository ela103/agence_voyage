package com.ela.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ela.projet.model.Voyage;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    
}
