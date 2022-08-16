package me.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.crm.entity.Client;

@Repository
public class ClientDAOHibernateImpl implements ClientDAO{

	private EntityManager entityManager;
	
	@Autowired
	public ClientDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Client> findAll() {
		
		// get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);
		
		// execute query and get result list
		List<Client> clients = theQuery.getResultList();
		
		// return the results
		return clients;
	}

	@Override
	public Client findById(int id) {
		
		// get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the client
		Client client = currentSession.get(Client.class, id);
		
		// return the client
		return client;
	}

	@Override
	public void save(Client client) {
		
		// get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save client
		currentSession.saveOrUpdate(client);
	}

	@Override
	public void deleteById(int id) {
		
		// get the current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query query = currentSession.createQuery("delete from Client where id=:clientId");
		query.setParameter("clientId", id);
		query.executeUpdate();
	}

}
