package cl.oriflame.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Client {
	@Id
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Order> orders;
}
