package cl.oriflame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.oriflame.model.Sale;
import cl.oriflame.service.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAll() {
		List<Sale> sales = saleService.findAll();
		
		if(sales == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(sales,HttpStatus.OK);
	}
}
