package cl.oriflame.model;

import java.util.List;

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
@Table(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="total_price")
	private int totalPrice;
	
	@Column(name="client_id")
	private Integer clientId;
	
	@Column
	private boolean active;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false, insertable=false, updatable=false)
	private Client client;
	
	@JsonIgnore
	@OneToMany(mappedBy="order")
	private List<ProductOrder> productOrders;
}
