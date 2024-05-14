package com.adictos.tutorial.domain.client.adapter;

import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientInboundPort;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
class ClientInboundAdapter implements ClientInboundPort {
	private final ClientOutboundPort port;

	public ClientInboundAdapter(ClientOutboundPort port) {
		this.port = port;
	}

	@Override
	public Client create(Client client) {
		return port.create(client);
	}

	@Override
	public List<Client> findAll() {
		return port.findAll();
	}
}
