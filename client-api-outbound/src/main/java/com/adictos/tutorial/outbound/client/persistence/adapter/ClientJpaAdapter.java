package com.adictos.tutorial.outbound.client.persistence.adapter;

import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;
import com.adictos.tutorial.outbound.client.persistence.ClientJpaRepository;
import com.adictos.tutorial.outbound.client.persistence.mapper.ClientMapper;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ClientJpaAdapter implements ClientOutboundPort {

	private final ClientJpaRepository repository;

	public ClientJpaAdapter(ClientJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Client create(Client client) {
		return ClientMapper.toDomain(repository.save(ClientMapper.toEntity(client)));
	}

	@Override
	public List<Client> findAll() {
		return ClientMapper.toDomain(repository.findAll());
	}
}
