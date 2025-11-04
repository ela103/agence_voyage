package com.ela.projet.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ela.projet.model.Client;
import com.ela.projet.repository.ClientRepository;

@Service
public class ClientService {
//service pour la gestion des clients
    @Autowired
    private ClientRepository clientRepository;

    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> listerClients() {
        return clientRepository.findAll();
    }

    public Client trouverClientParId(Long id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Client non trouvé"));
    }


    public void supprimerClient(Long id) {
        Client client = trouverClientParId(id);
        clientRepository.delete(client);
    }
}