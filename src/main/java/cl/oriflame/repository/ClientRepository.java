package cl.oriflame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.oriflame.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
	List<Client> findAll();
}
