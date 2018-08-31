package cl.oriflame.service;

import java.util.List;

import cl.oriflame.model.Order;

public interface OrderService {
	List<Order> findAll();
}
