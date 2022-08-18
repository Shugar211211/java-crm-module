package me.crm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="company")
	private String company;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;
	
	// https://www.appsdeveloperblog.com/infinite-recursion-in-objects-with-bidirectional-relationships/
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL,
				fetch=FetchType.EAGER)
	@JoinColumn(name="client_details_id")
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private ClientDetails clientDetails;
	
	// no-args constructor required by Hibernate
	public Client() {
	}

	public Client(
			String firstName, 
			String lastName, 
			String company, 
			String email, 
			String password,
			String status) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.company = company;
	this.email = email;
	this.password = password;
	this.status = status;
	}
	
	public Client(
					String firstName, 
					String lastName, 
					String company, 
					String email, 
					String password,
					String status,
					ClientDetails clientDetails) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.email = email;
		this.password = password;
		this.status = status;
		this.clientDetails = clientDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}
}
