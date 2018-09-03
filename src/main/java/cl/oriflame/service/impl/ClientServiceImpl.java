package cl.oriflame.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.oriflame.model.Client;
import cl.oriflame.repository.ClientRepository;
import cl.oriflame.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public Client setInactive(Integer id) {
		Client client = clientRepository.findById(id)
					.orElse(null);
		
		if(client == null)
			return null;
		
		client.setActive(false);
		return clientRepository.save(client);
	}
	
	public Client setActive(Integer id) {
		Client client = clientRepository.findById(id)
				.orElse(null);
	
		if(client == null)
			return null;
		
		client.setActive(true);
		return clientRepository.save(client);
	}
}
