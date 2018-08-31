package cl.oriflame.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="expiration_date")
	private Date expirationDate;
	
	@Column(name="product_id")
	private Integer productId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false, insertable=false, updatable=false)
	private Product product;
	
	@JsonIgnore
	@OneToMany(mappedBy="productDetail", cascade=CascadeType.ALL)
	private List<ProductOrder> productOrders;
}
