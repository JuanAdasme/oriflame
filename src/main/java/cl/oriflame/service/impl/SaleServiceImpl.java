package cl.oriflame.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.oriflame.model.Sale;
import cl.oriflame.repository.SaleRepository;
import cl.oriflame.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findAll() {
		return saleRepository.findAll();
	}
	
	public Sale save(Sale sale) {
		return saleRepository.save(sale);
	}
	
	public Sale setInactive(Integer id) {
		Sale sale = saleRepository.findById(id)
						.orElse(null);
		if(sale == null)
			return null;
		sale.setActive(false);
		return saleRepository.save(sale);
	}
	
	public Sale setActive(Integer id) {
		Sale sale = saleRepository.findById(id)
						.orElse(null);
		if(sale == null)
			return null;
		sale.setActive(true);
		return saleRepository.save(sale);
	}
}
