package me.crm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.crm.entity.Client;
import me.crm.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientRestController {

	private ClientService clientService;
	
	// autowire the ClientService
	@Autowired
	public ClientRestController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	// get list of all clients
	@GetMapping("/clients")
	public List<Client> getClients() {
		return clientService.findAll();
	}
	
	// get client by id
	@GetMapping("/clients/{clientId}")
	public Client getClient(@PathVariable int clientId) {
		Client client = clientService.findById(clientId);
		if(client == null) {
			throw new RuntimeException("Client id not found " + clientId);
		}
		return client;
	}
	
	// add new client
	@PostMapping("/clients")
	public Client addClient(@RequestBody Client client) {
		// set clientId to 0 to force save, and not update existing client
		client.setId(0);
		clientService.save(client);
		return client;
	}
	
	// update existing client
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client client) {
		clientService.save(client);
		return client;
	}
	
	// delete an existing employee
	@DeleteMapping("/clients/{clientId}")
	public String deleteClient(@PathVariable int clientId) {
		Client client = clientService.findById(clientId);
		// throw exception if client not found
		if(client == null) {
			throw new RuntimeException("Client id not found: " + clientId);
		}
		clientService.deleteById(clientId);
		return "Deleted client id - " + clientId;
	}
}
