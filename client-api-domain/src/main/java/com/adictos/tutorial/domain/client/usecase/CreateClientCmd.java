package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.architecture.usecase.Command;
import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;

import static com.adictos.tutorial.architecture.context.ServiceLocator.locate;

public class CreateClientCmd extends Command<Client> {

	private final Client client;
	private final ClientOutboundPort clientPort;

	CreateClientCmd(
			Client clientToCreate,
			ClientOutboundPort clientOutboundPort
	) {
		client = clientToCreate;
		clientPort = clientOutboundPort;
	}

	public CreateClientCmd(
			Client clientToCreate
	) {
		this(clientToCreate, locate(ClientOutboundPort.class));
	}

	@Override
	protected Client run() {
		return clientPort.create(client);
	}
}
