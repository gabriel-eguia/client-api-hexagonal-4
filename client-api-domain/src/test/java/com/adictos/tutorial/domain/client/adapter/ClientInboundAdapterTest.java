package com.adictos.tutorial.domain.client.adapter;

import com.adictos.tutorial.domain.client.port.ClientOutboundPort;
import com.adictos.tutorial.domain.client.model.Client;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class ClientInboundAdapterTest {

    private final ClientOutboundPort clientPort = mock(ClientOutboundPort.class);
    private final ClientInboundAdapter sut = new ClientInboundAdapter(clientPort);

    @Test
    void create_whenInvoke_thenCallCreateFromCreatePort() {
        var client = new Client(null, "name", "lastName");

        sut.create(client);

        verify(clientPort).create(client);
    }

    @Test
    void create_whenPortReturnClient_thenReturnCorrectly() {
        var client = new Client(null, "name", "lastName");
        var clientExpected = new Client(1L, client.name(), client.lastName());
        doReturn(clientExpected).when(clientPort).create(client);

        var result = sut.create(client);

        assertEquals(clientExpected, result);
    }

    @Test
    void findAll_whenInvoke_thenCallFindAllCreatePort() {
        sut.findAll();

        verify(clientPort).findAll();
    }

    @Test
    void findAll_whenPortReturnElements_thenReturnCorrectly() {
        var expectedList = List.of(
                new Client(1L, "name", "lastName"),
                new Client(2L, "name", "lastName")
        );
        doReturn(expectedList).when(clientPort).findAll();

        var result = sut.findAll();

        assertEquals(expectedList, result);
    }

}
