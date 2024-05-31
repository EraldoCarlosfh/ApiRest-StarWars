package com.starwars.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="tb_starships")
public class Starships implements Serializable {

private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Starship id")
	@EqualsAndHashCode.Include
	@Id
	@JsonProperty
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ApiModelProperty(value = "Starship name")
	@JsonProperty
	private String name;
	
	@ApiModelProperty(value = "Starship size")
	@JsonProperty
	private Integer size;
	
	@ApiModelProperty(value = "Starship passengers")
	@JsonProperty
	private Integer passengers;	
		
	public void updateStarship(Starships starship) {
		name = starship.name;		
		size = starship.size;		
		passengers = starship.passengers;	
	}
		
}
