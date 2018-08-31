package cl.oriflame.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	private Integer id;
	
	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private int price;
	
	@Column
	private int stock;
	
	@JsonIgnore
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<ProductDetail> productDetails;
	
	@JsonIgnore
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<Sale> sales;
}
