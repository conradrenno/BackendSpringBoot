package com.devrenno.BackendSpringBoot.controllers;

import com.devrenno.BackendSpringBoot.dto.ClientDTO;
import com.devrenno.BackendSpringBoot.entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @GetMapping(value = "/id")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO clientDTO = serviceClient.findById(id);
        return ResponseEntity.ok(clientDTO);
    }
}
