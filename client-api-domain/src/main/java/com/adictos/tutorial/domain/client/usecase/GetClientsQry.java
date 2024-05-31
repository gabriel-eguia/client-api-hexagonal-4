package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.architecture.usecase.Query;
import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;

import java.util.List;

import static com.adictos.tutorial.architecture.context.ServiceLocator.locate;

public class GetClientsQry extends Query<List<Client>> {

	private final ClientOutboundPort clientPort;

	GetClientsQry(
			ClientOutboundPort clientOutboundPort
	) {
		clientPort = clientOutboundPort;
	}

	public GetClientsQry() {
		this(locate(ClientOutboundPort.class));
	}

	@Override
	protected List<Client> run() {
		return clientPort.findAll();
	}
}
