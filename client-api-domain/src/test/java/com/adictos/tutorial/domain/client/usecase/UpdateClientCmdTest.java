package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UpdateClientCmdTest {

	private final ClientOutboundPort clientPort = mock(ClientOutboundPort.class);

	@Test
	void run_whenInvoked_shouldCallClientOutboundPortUpdate() {
		Client client = mock(Client.class);
		doReturn(client).when(clientPort).update(client);

		new UpdateClientCmd(client, clientPort).run();

		verify(clientPort).update(client);
	}

}
