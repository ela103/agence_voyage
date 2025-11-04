package com.ela.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ela.projet.model.Voyage;
import com.ela.projet.repository.VoyageRepository;

@Service
public class VoyageService {

    @Autowired
    private VoyageRepository voyageRepository;

    // Ajouter un voyage
    public Voyage ajouterVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    // Lister tous les voyages
    public List<Voyage> listerVoyages() {
        return voyageRepository.findAll();
    }

    // Trouver un voyage par id
    public Voyage trouverVoyageParId(Long id) {
        return voyageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Voyage non trouvé"));
    }

    // Mettre à jour un voyage
    public Voyage mettreAJourVoyage(Long id, Voyage voyageDetails) {
        Voyage voyage = trouverVoyageParId(id);
        voyage.setDestination(voyageDetails.getDestination());
        voyage.setPrixParPersonne(voyageDetails.getPrixParPersonne());
        return voyageRepository.save(voyage);
    }

    // Supprimer un voyage
    public void supprimerVoyage(Long id) {
        Voyage voyage = trouverVoyageParId(id);
        voyageRepository.delete(voyage);
    }
}

