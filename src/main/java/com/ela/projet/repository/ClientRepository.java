package com.ela.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ela.projet.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Client findByEmail(String email);
}
