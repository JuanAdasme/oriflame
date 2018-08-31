package cl.oriflame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {
	@Id
	private Integer id;
	
	@Column(name="product_detail_id")
	private Integer productDetailId;
	
	@Column(name="order_id")
	private Integer orderId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="product_detail_id", nullable=false, insertable=false, updatable=false)
	private ProductDetail productDetail;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false, insertable=false, updatable=false)
	private Order order;
}
