package com.ela.projet.controller;

import java.math.BigDecimal;
import java.util.List;

import com.ela.projet.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ela.projet.model.Paiement;
import com.ela.projet.service.PaiementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final ReservationService reservationService;

    @Autowired
    private PaiementService paiementService;

    PaiementController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/{reservationId}")
    public Paiement effectuerPaiement(
            @PathVariable Long reservationId,
            @RequestParam BigDecimal montant) {

        return paiementService.effectuerPaiement(
            reservationService.trouverReservationParId(reservationId), montant);
    }

    @GetMapping("/{id}")
    public Paiement trouverPaiement(@PathVariable Long id) {
        return paiementService.trouverPaiementParId(id);
    }
    @GetMapping
    public List<Paiement> listePaiements() {
        return paiementService.listerTousLesPaiements();
    }

    
}

