package me.crm.dao;

import java.util.List;

import me.crm.entity.Client;

public interface ClientDAO {
	
	public List<Client> findAll();
	
	public Client findById(int id);
	
	public void save(Client client);
	
	public void deleteById(int id);
}
