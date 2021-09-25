package com.starwars.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@ApiModelProperty(value = "Starship length")
	private Integer length;
	
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
	public Integer getAge() {
		return length;
	}
	public void setAge(Integer length) {
		this.length = length;
	}
	public Integer getHeight() {
		return passengers;
	}
	public void setHeight(Integer passengers) {
		this.passengers = passengers;
	}
		
}
