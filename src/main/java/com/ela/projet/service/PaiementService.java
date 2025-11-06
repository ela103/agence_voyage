package com.ela.projet.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ela.projet.model.Paiement;
import com.ela.projet.model.Reservation;
import com.ela.projet.model.StatutPaiement;
import com.ela.projet.repository.PaiementRepository;
import com.ela.projet.repository.ReservationRepository;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Paiement effectuerPaiement(Reservation reservation, BigDecimal montant) {
        // Vérifier si le montant est correct
        if (!reservation.getMontantTotal().equals(montant)) {
            throw new RuntimeException("Le montant du paiement est incorrect.");
        }

        Paiement paiement = new Paiement();
        paiement.setReservation(reservation);
        paiement.setDatePaiement(LocalDate.now());
        paiement.setMontant(montant);
        paiement.setStatut(StatutPaiement.PAYE);

        return paiementRepository.save(paiement);
    }

    public Paiement trouverPaiementParId(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé"));
    }
    public List<Paiement> listerTousLesPaiements() {
        return paiementRepository.findAll();
    }

}

