package com.starwars.apirest.models;

import java.io.Serializable;
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
@Table(name="tb_pilots")
@Entity
public class Pilots implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Pilot id")
	@EqualsAndHashCode.Include
	@Id
	@JsonProperty
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ApiModelProperty(value = "Pilot name")
	@JsonProperty
	private String name;
	
	@ApiModelProperty(value = "Pilot age")
	@JsonProperty
	private Integer age;
	
	@ApiModelProperty(value = "Pilot height")
	@JsonProperty
	private Integer height;
	
	@ApiModelProperty(value = "Pilot gender")
	@JsonProperty
	private String gender;
	
	public void updatePilot(Pilots pilot) {
		name = pilot.name;		
		age = pilot.age;		
		height = pilot.height;		
		gender = pilot.gender;		
	}
	
	//@OneToMany(mappedBy="pilots")
	//private List<Films> film;
		
}
