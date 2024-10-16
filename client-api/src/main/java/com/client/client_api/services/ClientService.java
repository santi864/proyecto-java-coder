package com.client.client_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.client_api.models.Client;
import com.client.client_api.repositories.ClientRepository;

/**
 * ClientService
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    public Optional<Client> getClientById(UUID id) {
        return this.clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        return this.clientRepository.save(client);
    }

    public Client updateClient(UUID id, Client client) {
        return this.clientRepository.findById(id)
                .map(existingClient -> {
                    existingClient.setName(client.getName());
                    existingClient.setDni(client.getDni());
                    existingClient.setEmail(client.getEmail());
                    return clientRepository.save(existingClient);
                })
                .orElseThrow(() -> new RuntimeException("La busqueda no dio resultados"));
    }

    public void deleteClient(UUID id) {
        this.clientRepository.deleteById(id);
    }

}