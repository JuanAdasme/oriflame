package cl.oriflame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.oriflame.model.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder,Integer> {
	List<ProductOrder> findAll();
}
