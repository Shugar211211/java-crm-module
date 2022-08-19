package me.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.crm.entity.Client;
import me.crm.repo.ClientRepo;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepo clientRepo;
	
	@Autowired
	public ClientServiceImpl(ClientRepo clientRepo) {
		this.clientRepo = clientRepo;
	}

	@Override
	public List<Client> findAll() {
		return clientRepo.findAll();
	}

	@Override
	public Client findById(int id) {
		Optional<Client> result = clientRepo.findById(id);
		return result.get();
	}

	@Override
	public void save(Client client) {
		clientRepo.save(client);
		
	}

	@Override
	public void deleteById(int id) {
		clientRepo.deleteById(id);
	}

}
