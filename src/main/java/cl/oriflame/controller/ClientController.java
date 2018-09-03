package cl.oriflame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.oriflame.model.Client;
import cl.oriflame.service.ClientService;
import cl.oriflame.utils.Utils;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping("find-all")
	public ResponseEntity<?> findAll() {
		List<Client> clients = clientService.findAll();

		if (clients == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(clients, HttpStatus.OK);
	}

	@PostMapping("save")
	public ResponseEntity<?> save(@RequestBody Client client) {
		if(client == null) 
			return Utils.badRequest();
		
		try {
			clientService.save(client);
			return new ResponseEntity<>(client, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(String.format("Error: %s", e.getMessage()));
			return Utils.badRequest();
		}
	}
	
	@GetMapping("disable")
	public ResponseEntity<?> setInactive(@RequestParam Integer id) {
		if(id == null)
			return Utils.badRequest();
		
		try {
			Client client = clientService.setInactive(id);
			if(client == null)
				return Utils.notFound();
			return new ResponseEntity<>(client,HttpStatus.OK);
		} catch (Exception e) {
			return Utils.serverError();
		}
	}
	
	@GetMapping("enable")
	public ResponseEntity<?> setActive(@RequestParam Integer id) {
		if(id == null)
			return Utils.badRequest();
		
		try {
			Client client = clientService.setActive(id);
			if(client == null)
				return Utils.notFound();
			return new ResponseEntity<>(client,HttpStatus.OK);
		} catch (Exception e) {
			return Utils.serverError();
		}
	}
}
