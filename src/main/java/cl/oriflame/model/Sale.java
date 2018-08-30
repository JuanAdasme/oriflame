package cl.oriflame.model;

import java.util.Date;

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
public class Sale {
	@Id
	private Integer id;
	
	@Column(name="discount_price")
	private int discountPrice;
	
	@Column
	private boolean active;
	
	@Column(name="limit_date")
	private Date limitDate;
	
	@Column(name="product_id")
	private Integer productId;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false, insertable=false, updatable=false)
	private Product product;
}
