package com.starwars.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ApiModelProperty(value = "Pilot name")
	private String name;
	
	@ApiModelProperty(value = "Pilot age")
	private Integer age;
	
	@ApiModelProperty(value = "Pilot height")
	private Integer height;
	
	@ApiModelProperty(value = "Pilot gender")
	private String gender;
	
	//@OneToMany(mappedBy="pilots")
	//private List<Films> film;
		
}
