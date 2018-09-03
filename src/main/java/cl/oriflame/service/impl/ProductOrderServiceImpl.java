package cl.oriflame.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.oriflame.model.ProductOrder;
import cl.oriflame.repository.ProductOrderRepository;
import cl.oriflame.service.ProductOrderService;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	@Override
	public List<ProductOrder> findAll() {
		return productOrderRepository.findAll();
	}
	
	@Override
	public ProductOrder save(ProductOrder productOrder) {
		return productOrderRepository.save(productOrder);
	}
}
