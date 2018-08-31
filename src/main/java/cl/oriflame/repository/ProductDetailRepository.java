package cl.oriflame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.oriflame.model.ProductDetail;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Integer> {
	List<ProductDetail> findAll();
}
