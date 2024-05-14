package com.adictos.tutorial.domain.client.port;

import com.adictos.tutorial.domain.client.model.Client;

import java.util.List;

public interface ClientInboundPort {
    Client create(Client client);
    List<Client> findAll();
}
