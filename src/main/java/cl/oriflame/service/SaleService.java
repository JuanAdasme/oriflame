package cl.oriflame.service;

import java.util.List;

import cl.oriflame.model.Sale;

public interface SaleService {
	List<Sale> findAll();
	
	Sale save(Sale sale);
	
	Sale setInactive(Integer id);
	
	Sale setActive(Integer id);
}
