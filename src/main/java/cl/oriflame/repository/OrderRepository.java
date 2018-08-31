package cl.oriflame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.oriflame.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
	List<Order> findAll();
}
