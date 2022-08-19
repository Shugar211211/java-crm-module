package me.crm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import me.crm.entity.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {

}
