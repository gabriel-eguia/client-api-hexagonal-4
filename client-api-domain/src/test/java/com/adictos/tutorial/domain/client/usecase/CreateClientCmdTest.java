package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CreateClientCmdTest {

	private final ClientOutboundPort clientPort = mock(ClientOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallClientOutboundPortFindAll() {
		Client client = mock(Client.class);
		Client clientWithId = mock(Client.class);
		doReturn(clientWithId).when(clientPort).create(client);

		new CreateClientCmd(client, clientPort).run();

		verify(clientPort).create(client);
	}
}
