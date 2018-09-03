package cl.oriflame.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.oriflame.model.Order;
import cl.oriflame.repository.OrderRepository;
import cl.oriflame.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	public Order setInactive(Integer id) {
		Order order = orderRepository.findById(id)
						.orElse(null);
		if(order == null)
			return null;
		
		order.setActive(false);
		return orderRepository.save(order);
	}
	
	public Order setActive(Integer id) {
		Order order = orderRepository.findById(id)
						.orElse(null);
		if(order == null)
			return null;
		order.setActive(true);
		return orderRepository.save(order);
	}
}
