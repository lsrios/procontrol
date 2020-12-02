package br.com.projuris.procontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projuris.procontrol.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
