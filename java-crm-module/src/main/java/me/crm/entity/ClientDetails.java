package me.crm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="client_details")
public class ClientDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="notes")
	private String notes;

	
	@OneToOne(mappedBy="clientDetails",
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL)
	@JsonBackReference
	private Client client;
	
	// no-args constructor required by Hibernate
	public ClientDetails() {
	}
	
	public ClientDetails(String notes) {
		super();
		this.notes = notes;
	}
	
	public ClientDetails(int id, String notes) {
		super();
		this.id = id;
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
