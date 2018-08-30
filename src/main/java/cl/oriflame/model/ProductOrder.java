package cl.oriflame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
	@Id
	private Integer id;
	
	@Column(name="product_detail_id")
	private Integer productDetailId;
	
	@Column(name="oder_id")
	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name="product_detail_id", nullable=false, insertable=false, updatable=false)
	private ProductDetail productDetail;
	
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false, insertable=false, updatable=false)
	private Order order;
}
