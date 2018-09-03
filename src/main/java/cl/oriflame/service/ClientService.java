package cl.oriflame.service;

import java.util.List;

import cl.oriflame.model.Client;

public interface ClientService {
	List<Client> findAll();
	
	Client save(Client client);
	
	Client setInactive(Integer id);
	
	Client setActive(Integer id);
}
