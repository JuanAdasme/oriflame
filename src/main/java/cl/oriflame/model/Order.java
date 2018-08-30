package cl.oriflame.model;

import java.util.List;

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
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	private Integer id;
	
	@Column(name="total_price")
	private int totalPrice;
	
	@Column(name="client_id")
	private Integer clientId;
	
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false, insertable=false, updatable=false)
	private Client client;
	
	@OneToMany(mappedBy="order")
	private List<ProductOrder> productOrders;
}
