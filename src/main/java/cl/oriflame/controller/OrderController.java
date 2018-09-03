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

import cl.oriflame.model.Order;
import cl.oriflame.service.OrderService;
import cl.oriflame.utils.Utils;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAll() {
		List<Order> orders = orderService.findAll();
		
		if(orders == null)
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(orders,HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	@PostMapping("save")
	public ResponseEntity<?> save(@RequestBody Order order) {
		if(order == null)
			return Utils.badRequest();
		
		try {
			orderService.save(order);
			if(order == null)
				return Utils.badRequest();
			return new ResponseEntity<>(order, HttpStatus.OK);
		} catch (Exception e) {
			return Utils.serverError();
		}
	}
	
	@GetMapping("disable")
	public ResponseEntity<?> setInactive(@RequestParam Integer id) {
		if(id == null)
			return Utils.badRequest();
		
		try {
			Order order = orderService.setInactive(id);
			if(order == null)
				return Utils.notFound();
			return new ResponseEntity<>(order, HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(String.format("Error: %s", e.getMessage()));
			return Utils.serverError();
		}
	}
	
	@GetMapping("enable")
	public ResponseEntity<?> setActive(@RequestParam Integer id) {
		if(id == null)
			return Utils.badRequest();
		
		try {
			Order order = orderService.setActive(id);
			if(order == null)
				return Utils.notFound();
			return new ResponseEntity<>(order, HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(String.format("Error: %s", e.getMessage()));
			return Utils.serverError();
		}
	}
}
