package com.client.client_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.client.client_api.models.Client;

/**
 * ClientRepository
 */
public interface ClientRepository extends JpaRepository<Client,UUID>{

    
}