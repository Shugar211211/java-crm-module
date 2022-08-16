package me.crm.service;

import java.util.List;

import me.crm.entity.Client;

public interface ClientService {

	public List<Client> findAll();
	
	public Client findById(int id);
	
	public void save(Client client);
	
	public void deleteById(int id);
}
