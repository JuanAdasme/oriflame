package cl.oriflame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.oriflame.model.ProductOrder;
import cl.oriflame.service.ProductOrderService;

@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {
	@Autowired
	private ProductOrderService productOrderService;
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAll() {
		List<ProductOrder> productOrders = productOrderService.findAll();
		
		if(productOrders == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(productOrders,HttpStatus.OK);
	}
}
