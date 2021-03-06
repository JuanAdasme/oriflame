package cl.oriflame.service;

import java.util.List;

import cl.oriflame.model.Product;

public interface ProductService {
	List<Product> findAll();
	
	Product save(Product product);
	
	Product setInactive(Integer id);
	
	Product setActive(Integer id);
}
