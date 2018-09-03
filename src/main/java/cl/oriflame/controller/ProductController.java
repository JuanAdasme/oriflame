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

import cl.oriflame.model.Product;
import cl.oriflame.service.ProductService;
import cl.oriflame.utils.Utils;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("find-all")
	public ResponseEntity<?> findAll() {
		List<Product> products = productService.findAll();
		
		if(products == null)
			return Utils.notFound();
		
		return Utils.ok(products);
	}
	
	@PostMapping("save")
	public ResponseEntity<?> save(@RequestBody Product product) {
		if(product == null)
			return Utils.badRequest();
		
		try {
			productService.save(product);
			return Utils.ok(product);
		} catch (Exception e) {
			System.out.println(String.format("Error: %s", e.getMessage()));
			return Utils.badRequest();
		}
	}
	
	@GetMapping("disable")
	public ResponseEntity<?> setInactive(@RequestParam Integer id) {
		if(id == null)
			return Utils.badRequest();
		
		try {
			Product product = productService.setInactive(id);
			return Utils.ok(product);
		} catch (Exception e) {
			return Utils.badRequest();
		}
	}
	
	@GetMapping("enable")
	public ResponseEntity<?> setActive(@RequestParam Integer id) {
		if(id == null)
			return Utils.badRequest();
		
		try {
			Product product = productService.setActive(id);
			if(product == null)
				return Utils.badRequest();
			return Utils.ok(product);
		} catch (Exception e) {
			return Utils.serverError();
		}
	}
}
