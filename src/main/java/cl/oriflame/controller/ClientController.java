package cl.oriflame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.oriflame.model.Client;
import cl.oriflame.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("find-all")
	public ResponseEntity<?> findAll() {
		List<Client> clients = clientService.findAll();
		
		if(clients == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(clients,HttpStatus.OK);
	}
}
