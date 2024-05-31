package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GetClientByIdQryTest {

	private final ClientOutboundPort clientPort = mock(ClientOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallClientOutboundPortFindById() {
		Long clientId = 1L;
		Client client = mock(Client.class);
		doReturn(client).when(clientPort).findById(clientId);

		new GetClientByIdQry(clientId, clientPort).run();

		verify(clientPort).findById(clientId);
	}
}
