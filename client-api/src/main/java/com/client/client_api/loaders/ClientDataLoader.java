package com.client.client_api.loaders;

import com.client.client_api.models.Client;
import com.client.client_api.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientDataLoader implements CommandLineRunner {

    private final ClientService clientService;

    @Autowired
    public ClientDataLoader(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Populate 10 clients
        for (int i = 1; i <= 10; i++) {
            Client client = new Client();
            client.setId(UUID.randomUUID());
            client.setName("Client Name " + i);
            client.setDni(String.format("%08d", i * 12345)); // Example of a simple DNI pattern
            client.setEmail("client" + i + "@example.com");

            clientService.createClient(client);
        }

        System.out.println("10 Clients populated successfully!");
    }
}
