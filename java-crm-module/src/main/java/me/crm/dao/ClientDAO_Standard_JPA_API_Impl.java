package me.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.crm.entity.Client;

@Repository
public class ClientDAO_Standard_JPA_API_Impl implements ClientDAO{

	private EntityManager entityManager;
	
	@Autowired
	public ClientDAO_Standard_JPA_API_Impl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Client> findAll() {	
		// create query
		TypedQuery<Client> query = entityManager.createQuery("from Client", Client.class);
		
		// execute query and get results list
		List<Client> clients = query.getResultList();
		
		// return the results
		return clients;
	}

	@Override
	public Client findById(int id) {
		// get client
		Client client = entityManager.find(Client.class, id);
		
		//return client
		return client;
	}

	@Override
	public void save(Client client) {
		// save or update client
		// if id == 0, then save/insert, else update
		
		// get client_details id of previous record of client_details;
		int oldId=0;
		if(client.getId() != 0) {
			oldId = this.findById(client.getId()).getClientDetails().getId();		
		}
		
		// update with id from db... so we can get generated id for save/insert
		// useful in REST API to return generated id
		Client dbClient = entityManager.merge(client);
		client.setId(dbClient.getId());
		
		// delete previous record from table client_details
		if(client.getId() != 0) {
			Query query	= entityManager.createNativeQuery("delete from client_details where id=:oldId");
			query.setParameter("oldId", oldId);
			query.executeUpdate();
		}
	}

	@Override
	public void deleteById(int id) {
		
		// get id of client_details entry, that will deleted
		int clientDetailsId = this.findById(id).getClientDetails().getId();
		
		// delete client object with primary key
		Query query	= entityManager.createQuery("delete from Client where id=:clientId");
		query.setParameter("clientId", id);
		query.executeUpdate();
		
		// delete client_details entry
		query = entityManager.createNativeQuery("delete from client_details where id=:clientDetailsId");
		query.setParameter("clientDetailsId", clientDetailsId);
		query.executeUpdate();
	}

}
