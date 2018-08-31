package cl.oriflame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.oriflame.model.Product;
import cl.oriflame.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAll() {
		List<Product> products = productService.findAll();
		
		if(products == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Product product) {
		Product prod = productService.save(product);
		
		if(prod == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(prod,HttpStatus.OK);
	}
}
