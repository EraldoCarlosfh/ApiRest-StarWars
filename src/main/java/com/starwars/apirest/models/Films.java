package com.starwars.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_films")
@Entity
public class Films implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "Film id")
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ApiModelProperty(value = "Film title")
	@JsonProperty
	private String title;

	@ApiModelProperty(value = "Film episode")
	@JsonProperty
	private Integer episode;

	public void updateFilme(Integer episodeEdit, String titleEdit) {
		episode = episodeEdit;		
		title = titleEdit;		
	}
	
	//@ManyToOne
	//@JoinColumn(name="pilots_id")
	//private Pilots pilots;
		
}
