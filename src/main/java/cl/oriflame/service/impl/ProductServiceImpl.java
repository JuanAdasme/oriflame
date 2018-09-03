package cl.oriflame.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.oriflame.model.Product;
import cl.oriflame.repository.ProductRepository;
import cl.oriflame.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public Product setInactive(Integer id) {
		Product product = productRepository.findById(id)
							.orElse(null);
		
		if (product == null)
			return null;
		
		product.setActive(false);
		return productRepository.save(product);
	}
	
	@Override
	public Product setActive(Integer id) {
		Product product = productRepository.findById(id)
							.orElse(null);
		
		if (product == null)
			return null;
		
		product.setActive(true);
		return productRepository.save(product);
	}
}
