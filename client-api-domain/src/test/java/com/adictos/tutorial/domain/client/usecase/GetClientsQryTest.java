package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class GetClientsQryTest {

	private final ClientOutboundPort clientPort = mock(ClientOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallClientOutboundPortFindAll() {
		Client client = mock(Client.class);
		doReturn(List.of(client)).when(clientPort).findAll();

		new GetClientsQry(clientPort).run();

		verify(clientPort).findAll();
	}
}
