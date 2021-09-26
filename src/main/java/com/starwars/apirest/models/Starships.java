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

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="tb_starships")
public class Starships implements Serializable {

private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Starship id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ApiModelProperty(value = "Starship name")
	private String name;
	
	@ApiModelProperty(value = "Starship size")
	private Integer size;
	
	@ApiModelProperty(value = "Starship passengers")
	private Integer passengers;	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getPassengers() {
		return passengers;
	}
	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}
		
}
