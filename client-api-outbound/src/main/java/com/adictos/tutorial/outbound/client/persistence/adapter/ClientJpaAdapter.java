package com.adictos.tutorial.outbound.client.persistence.adapter;

import com.adictos.tutorial.domain.client.model.Client;
import com.adictos.tutorial.domain.client.port.ClientOutboundPort;
import com.adictos.tutorial.outbound.client.persistence.ClientJpaRepository;
import com.adictos.tutorial.outbound.client.persistence.mapper.ClientMapper;
import com.adictos.tutorial.outbound.client.persistence.model.ClientEntity;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Client findById(Long clientId) {
		Optional<ClientEntity> result = repository.findById(clientId);
		return result.map(ClientMapper::toDomain).orElse(null);
	}

	@Override
	public Client update(Client client) {
		return ClientMapper.toDomain(repository.save(ClientMapper.toEntity(client)));
	}
}
