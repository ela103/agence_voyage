package com.ela.projet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ela.projet.model.Client;
import com.ela.projet.model.Voyage;
import com.ela.projet.model.Reservation;
import com.ela.projet.repository.ClientRepository;
import com.ela.projet.repository.VoyageRepository;
import com.ela.projet.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private VoyageRepository voyageRepository;

    // ➕ Ajouter une réservation
    public Reservation ajouterReservation(Reservation reservation) {
        if (reservation.getClient() != null && reservation.getClient().getId() != null) {
            Client client = clientRepository.findById(reservation.getClient().getId())
                    .orElseThrow(() -> new RuntimeException("Client non trouvé"));
            reservation.setClient(client);
        }

        if (reservation.getVoyage() != null && reservation.getVoyage().getId() != null) {
            Voyage voyage = voyageRepository.findById(reservation.getVoyage().getId())
                    .orElseThrow(() -> new RuntimeException("Voyage non trouvé"));
            reservation.setVoyage(voyage);
        }

        return reservationRepository.save(reservation);
    }

    // 📋 Lister toutes les réservations
    public List<Reservation> listerReservations() {
        return reservationRepository.findAll();
    }

    // 🔍 Trouver une réservation par ID
    public Reservation trouverReservationParId(Long id) {
        return reservationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Réservation non trouvée"));
    }

    // ✏️ Mettre à jour une réservation
    public Reservation mettreAJourReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = trouverReservationParId(id);

        if (reservationDetails.getClient() != null && reservationDetails.getClient().getId() != null) {
            Client client = clientRepository.findById(reservationDetails.getClient().getId())
                    .orElseThrow(() -> new RuntimeException("Client non trouvé"));
            reservation.setClient(client);
        }

        if (reservationDetails.getVoyage() != null && reservationDetails.getVoyage().getId() != null) {
            Voyage voyage = voyageRepository.findById(reservationDetails.getVoyage().getId())
                    .orElseThrow(() -> new RuntimeException("Voyage non trouvé"));
            reservation.setVoyage(voyage);
        }

        reservation.setDateReservation(reservationDetails.getDateReservation());
        reservation.setNombrePersonnes(reservationDetails.getNombrePersonnes());
        reservation.setMontantTotal(reservationDetails.getMontantTotal());
        reservation.setStatut(reservationDetails.getStatut());

        return reservationRepository.save(reservation);
    }

    // ❌ Supprimer une réservation
    public void supprimerReservation(Long id) {
        Reservation reservation = trouverReservationParId(id);
        reservationRepository.delete(reservation);
    }
}
