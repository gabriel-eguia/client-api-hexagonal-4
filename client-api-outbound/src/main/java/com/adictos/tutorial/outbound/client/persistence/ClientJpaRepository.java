package com.adictos.tutorial.outbound.client.persistence;

import com.adictos.tutorial.outbound.client.persistence.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
}
