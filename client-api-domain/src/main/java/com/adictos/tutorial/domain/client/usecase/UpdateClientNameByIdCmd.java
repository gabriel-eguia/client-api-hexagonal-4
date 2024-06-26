package com.adictos.tutorial.domain.client.usecase;

import com.adictos.tutorial.architecture.usecase.Command;
import com.adictos.tutorial.domain.client.model.Client;

public class UpdateClientNameByIdCmd extends Command<Client> {

	private final Long clientId;
	private final String newName;

	public UpdateClientNameByIdCmd(
			Long clientId,
			String newName
	) {
		this.clientId = clientId;
		this.newName = newName;
	}

	@Override
	protected Client run() {
		Client client = run(new GetClientByIdQry(clientId));
		Client clientToUpdate = new Client(
				client.id(),
				newName,
				client.lastName()
		);
		return run(new UpdateClientCmd(clientToUpdate));
	}
}
