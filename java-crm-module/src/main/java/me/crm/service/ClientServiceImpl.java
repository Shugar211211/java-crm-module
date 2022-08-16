package me.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.crm.dao.ClientDAO;
import me.crm.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientDAO clientDAO;
	
	@Autowired
	public ClientServiceImpl(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	@Transactional
	public List<Client> findAll() {
		return clientDAO.findAll();
	}

	@Override
	@Transactional
	public Client findById(int id) {
		return clientDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Client client) {
		clientDAO.save(client);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		clientDAO.deleteById(id);
	}

}
