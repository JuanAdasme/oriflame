package cl.oriflame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.oriflame.model.ProductDetail;
import cl.oriflame.service.ProductDetailService;

@RestController
@RequestMapping("/product-details")
public class ProductDetailController {
	@Autowired
	private ProductDetailService productDetailService;
	
	@GetMapping("/find-all")
	private ResponseEntity<?> findAll() {
		List<ProductDetail> productDetails = productDetailService.findAll();
		
		if(productDetails == null) 
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(productDetails,HttpStatus.OK);
	}
}
