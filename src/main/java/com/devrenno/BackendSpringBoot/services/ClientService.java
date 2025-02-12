package com.devrenno.BackendSpringBoot.services;

import com.devrenno.BackendSpringBoot.dto.ClientDTO;
import com.devrenno.BackendSpringBoot.entities.Client;
import com.devrenno.BackendSpringBoot.repositories.ClientRepository;
import com.devrenno.BackendSpringBoot.services.exceptions.ElementNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;


    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){

        Client client = repository.findById(id).orElseThrow(
                () -> new ElementNotFoundException("Element not found")
        );

        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){

        Page<Client> clients = repository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO){

            Client client = new Client();
            copyDtoToEntity(clientDTO, client);
            client = repository.save(client);
            return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO){

        try {
            Client client = repository.getReferenceById(id);
            copyDtoToEntity(clientDTO, client);
            client = repository.save(client);
            return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw new ElementNotFoundException("Element not found");
        }
    }

    @Transactional
    public void delete(Long id){

        if (!repository.existsById(id)){
            throw new ElementNotFoundException("Element not found");
        } else {
            repository.deleteById(id);
        }
    }

    public void copyDtoToEntity(ClientDTO clientDTO, Client client){

        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
    }

}
