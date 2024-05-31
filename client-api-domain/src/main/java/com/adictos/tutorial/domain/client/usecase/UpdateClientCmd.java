package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.architecture.usecase.Command;
import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;

import static com.adictos.tutorial.architecture.context.ServiceLocator.locate;

public class UpdateClientCmd extends Command<Client> {

	private final Client client;
	private final ClientOutboundPort clientPort;

	UpdateClientCmd(
			Client clientToUpdate,
			ClientOutboundPort clientOutboundPort
	) {
		client = clientToUpdate;
		clientPort = clientOutboundPort;
	}

	public UpdateClientCmd(
			Client clientToUpdate
	) {
		this(clientToUpdate, locate(ClientOutboundPort.class));
	}

	@Override
	protected Client run() {
		return clientPort.update(client);
	}
}
