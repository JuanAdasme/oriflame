package cl.oriflame.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
	@Id
	private Integer id;
	
	@Column(name="expiration_date")
	private Date expirationDate;
	
	@Column(name="product_id")
	private Integer productId;
	
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false, insertable=false, updatable=false)
	private Product product;
	
	@OneToMany(mappedBy="productDetail", cascade=CascadeType.ALL)
	private List<ProductOrder> productOrders;
}