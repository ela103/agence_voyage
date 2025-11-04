package com.ela.projet.controller;

import com.ela.projet.model.Reservation;
import com.ela.projet.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @GetMapping
    public List<Reservation> listerReservations() {
        return reservationService.listerReservations();
    }

    @GetMapping("/{id}")
    public Reservation trouverReservation(@PathVariable Long id) {
        return reservationService.trouverReservationParId(id);
    }

    @PutMapping("/{id}")
    public Reservation mettreAJourReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        return reservationService.mettreAJourReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void supprimerReservation(@PathVariable Long id) {
        reservationService.supprimerReservation(id);
    }
}
