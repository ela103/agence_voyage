package com.ela.projet.controller;

import com.ela.projet.model.Paiement;
import com.ela.projet.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @PostMapping
    public Paiement effectuerPaiement(@RequestBody Paiement paiement) {
        return paiementService.effectuerPaiement(paiement);
    }

    @GetMapping
    public List<Paiement> listerPaiements() {
        return paiementService.listerPaiements();
    }

    @GetMapping("/{id}")
    public Paiement trouverPaiement(@PathVariable Long id) {
        return paiementService.trouverPaiementParId(id);
    }

    @PutMapping("/{id}")
    public Paiement mettreAJourPaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        return paiementService.mettreAJourPaiement(id, paiement);
    }

    @DeleteMapping("/{id}")
    public void supprimerPaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
    }
}