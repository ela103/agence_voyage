package com.ela.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ela.projet.model.Reservation;
import com.ela.projet.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> listerReservations() {
        return reservationRepository.findAll();
    }

    public Reservation trouverReservationParId(Long id) {
        return reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Reservation non trouvée"));
    }

    public Reservation mettreAJourReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = trouverReservationParId(id);
        reservation.setClient(reservationDetails.getClient());
        reservation.setVoyage(reservationDetails.getVoyage());
        reservation.setDateReservation(reservationDetails.getDateReservation());
        reservation.setNombrePersonnes(reservationDetails.getNombrePersonnes());
        return reservationRepository.save(reservation);
    }

    public void supprimerReservation(Long id) {
        Reservation reservation = trouverReservationParId(id);
        reservationRepository.delete(reservation);
    } }
