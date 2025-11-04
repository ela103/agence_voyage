package com.ela.projet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@NotBlank
    
    private String nom;
@NotBlank @Email
    
    private String email;

@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
private List<Reservation> reservations = new ArrayList<>();}
