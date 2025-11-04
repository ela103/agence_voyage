package com.ela.projet.controller;

import com.ela.projet.model.Client;
import com.ela.projet.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Ajouter un client
    @PostMapping
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    // Lister tous les clients
    @GetMapping
    public List<Client> listerClients() {
        return clientService.listerClients();
    }

    // Trouver un client par ID
    @GetMapping("/{id}")
    public Client trouverClient(@PathVariable Long id) {
        return clientService.trouverClientParId(id);
    }

    
    // Supprimer un client
    @DeleteMapping("/{id}")
    public void supprimerClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
    }
}