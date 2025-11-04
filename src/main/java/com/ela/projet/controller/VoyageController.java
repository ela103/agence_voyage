package com.ela.projet.controller;

import com.ela.projet.model.Voyage;
import com.ela.projet.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voyages")
public class VoyageController {

    @Autowired
    private VoyageService voyageService;

    @PostMapping
    public Voyage ajouterVoyage(@RequestBody Voyage voyage) {
        return voyageService.ajouterVoyage(voyage);
    }

    @GetMapping
    public List<Voyage> listerVoyages() {
        return voyageService.listerVoyages();
    }

    @GetMapping("/{id}")
    public Voyage trouverVoyage(@PathVariable Long id) {
        return voyageService.trouverVoyageParId(id);
    }

    @PutMapping("/{id}")
    public Voyage mettreAJourVoyage(@PathVariable Long id, @RequestBody Voyage voyage) {
        return voyageService.mettreAJourVoyage(id, voyage);
    }

    @DeleteMapping("/{id}")
    public void supprimerVoyage(@PathVariable Long id) {
        voyageService.supprimerVoyage(id);
    }
}