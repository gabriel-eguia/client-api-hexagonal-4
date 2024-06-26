package com.adictos.tutorial.domain.client.adapter;

import com.adictos.tutorial.architecture.usecase.UseCaseBus;
import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.usecase.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientInboundAdapterTest {

	private final UseCaseBus bus = mock(UseCaseBus.class);
	private final ClientInboundAdapter sut = new ClientInboundAdapter(bus);

	@Test
	void create_whenInvoke_thenCallCreateClientCmd() {
		var client = new Client(null, "name", "lastName");

		sut.create(client);

		verify(bus).invoke(any(CreateClientCmd.class));
	}

	@Test
	void create_whenCreateClientCmdReturnClient_thenReturnCorrectly() {
		var client = new Client(null, "name", "lastName");
		var clientExpected = new Client(1L, client.name(), client.lastName());
		doReturn(clientExpected).when(bus).invoke(any(CreateClientCmd.class));

		var result = sut.create(client);

		assertEquals(clientExpected, result);
	}

	@Test
	void findAll_whenInvoke_thenCallGetClientsQry() {
		sut.findAll();

		verify(bus).invoke(any(GetClientsQry.class));
	}

	@Test
	void findAll_whenPortReturnElements_thenReturnCorrectly() {
		var expectedList = List.of(
				new Client(1L, "name", "lastName"),
				new Client(2L, "name", "lastName")
		);
		doReturn(expectedList).when(bus).invoke(any(GetClientsQry.class));

		var result = sut.findAll();

		assertEquals(expectedList, result);
	}

	@Test
	void updateClientNameById_whenInvoked_shouldCallUpdateClientNameByIdCmd() {
		var clientId = 1L;
		var newName = "newName";
		var updatedClient = new Client(
				clientId,
				newName,
				"lastName"
		);
		doReturn(updatedClient).when(bus).invoke(any(UpdateClientNameByIdCmd.class));

		sut.updateClientNameById(clientId, newName);

		verify(bus).invoke(any(UpdateClientNameByIdCmd.class));
	}
}
