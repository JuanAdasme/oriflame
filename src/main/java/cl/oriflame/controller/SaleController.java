package cl.oriflame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.oriflame.model.Sale;
import cl.oriflame.service.SaleService;
import cl.oriflame.utils.Utils;

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
	
	@SuppressWarnings("unused")
	@PostMapping("save")
	public ResponseEntity<?> save(@RequestBody Sale sale) {
		if(sale == null)
			return Utils.badRequest();
		System.out.println(String.format("Sale: %s", sale));
		try {
			saleService.save(sale);
			return Utils.ok(sale);
		} catch (Exception e) {
			System.out.println(String.format("Error: %s",e.getMessage()));
			return Utils.badRequest();
		}
	}
	
	@GetMapping("disable")
	public ResponseEntity<?> setInactive(@RequestParam Integer id) {
		if(id == null)
			return Utils.badRequest();
		try {
			Sale sale = saleService.setInactive(id);
			if(sale == null)
				return Utils.badRequest();
			return Utils.ok(sale);
		} catch (Exception e) {
			System.out.println(String.format("Error: %s", e.getMessage()));
			return Utils.badRequest();
		}
	}
	
	@GetMapping("enable")
	public ResponseEntity<?> setActive(@RequestParam Integer id) {
		if(id == null)
			return Utils.badRequest();
		try {
			Sale sale = saleService.setActive(id);
			if(sale == null)
				return Utils.badRequest();
			return Utils.ok(sale);
		} catch (Exception e) {
			System.out.println(String.format("Error: %s", e.getMessage()));
			return Utils.badRequest();
		}
	}
}
