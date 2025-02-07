package com.devrenno.BackendSpringBoot.services;

import com.devrenno.BackendSpringBoot.dto.ClientDTO;
import com.devrenno.BackendSpringBoot.entities.Client;
import com.devrenno.BackendSpringBoot.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientDTO findById(Long id){
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }
}
