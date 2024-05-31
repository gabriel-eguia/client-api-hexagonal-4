package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.architecture.usecase.Query;
import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;

import static com.adictos.tutorial.architecture.context.ServiceLocator.locate;

public class GetClientByIdQry extends Query<Client> {

	private final Long clientId;
	private final ClientOutboundPort clientPort;

	GetClientByIdQry(
			Long id,
			ClientOutboundPort clientOutboundPort
	) {
		clientId = id;
		clientPort = clientOutboundPort;
	}

	public GetClientByIdQry(
			Long id
	) {
		this(id, locate(ClientOutboundPort.class));
	}

	@Override
	protected Client run() {
		return clientPort.findById(clientId);
	}
}
