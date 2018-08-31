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
@Table(name="clients")
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
	
	@JsonIgnore
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Order> orders;
}
