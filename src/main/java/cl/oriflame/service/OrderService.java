package cl.oriflame.service;

import java.util.List;

import cl.oriflame.model.Order;

public interface OrderService {
	List<Order> findAll();
	
	Order save(Order order);
	
	Order setInactive(Integer id);
	
	Order setActive(Integer id);
}
