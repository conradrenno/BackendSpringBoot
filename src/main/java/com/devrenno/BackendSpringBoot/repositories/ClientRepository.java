package com.devrenno.BackendSpringBoot.repositories;

import com.devrenno.BackendSpringBoot.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public class ClientRepository implements JpaRepository<Client, Long> {

}
