package cl.oriflame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.oriflame.model.Sale;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
	List<Sale> findAll();
}
