package com.adictos.tutorial.domain.client.adapter;

import com.adictos.tutorial.architecture.usecase.UseCaseBus;
import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientInboundPort;
import com.adictos.tutorial.domain.client.usecase.*;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
class ClientInboundAdapter implements ClientInboundPort {
	private final UseCaseBus bus;

	public ClientInboundAdapter(UseCaseBus useCaseBus) {
		bus = useCaseBus;
	}

	@Override
	public Client create(Client client) {
		return bus.invoke(new CreateClientCmd(client));
	}

	@Override
	public List<Client> findAll() {
		return bus.invoke(new GetClientsQry());
	}

	@Override
	public Client updateClientNameById(Long clientId, String newName) {
		return bus.invoke(new UpdateClientNameByIdCmd(clientId, newName));
	}
}
