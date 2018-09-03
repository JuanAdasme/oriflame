package cl.oriflame.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.oriflame.model.ProductDetail;
import cl.oriflame.repository.ProductDetailRepository;
import cl.oriflame.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
	@Autowired
	private ProductDetailRepository productDetailRepository;
	
	@Override
	public List<ProductDetail> findAll() {
		return productDetailRepository.findAll();
	}
	
	@Override
	public ProductDetail save(ProductDetail productDetail) {
		return productDetailRepository.save(productDetail);
	}
}
