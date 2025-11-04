package com.ela.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ela.projet.model.Paiement;
import com.ela.projet.repository.PaiementRepository;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    /**
     * Ajouter ou effectuer un paiement
     */
    public Paiement effectuerPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    /**
     * Lister tous les paiements
     */
    public List<Paiement> listerPaiements() {
        return paiementRepository.findAll();
    }

    /**
     * Trouver un paiement par son ID
     */
    public Paiement trouverPaiementParId(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec l'id : " + id));
    }

    /**
     * Mettre à jour un paiement existant
     */
    public Paiement mettreAJourPaiement(Long id, Paiement paiementDetails) {
        Paiement paiement = trouverPaiementParId(id);
        paiement.setMontant(paiementDetails.getMontant());
        paiement.setDatePaiement(paiementDetails.getDatePaiement());
        paiement.setStatut(paiementDetails.getStatut());
        paiement.setReservation(paiementDetails.getReservation());
        return paiementRepository.save(paiement);
    }

    /**
     * Supprimer un paiement
     */
    public void supprimerPaiement(Long id) {
        Paiement paiement = trouverPaiementParId(id);
        paiementRepository.delete(paiement);
    }
}

