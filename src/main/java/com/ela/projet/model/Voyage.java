package com.ela.projet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String destination;

    @Positive
    private BigDecimal prixParPersonne;

    @OneToMany(mappedBy = "voyage", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getPrixParPersonne() {
		return prixParPersonne;
	}

	public void setPrixParPersonne(BigDecimal prixParPersonne) {
		this.prixParPersonne = prixParPersonne;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
