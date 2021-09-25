package com.starwars.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_films")
public class Films implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "Film id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ApiModelProperty(value = "Film title")
	private String title;

	@ApiModelProperty(value = "Film episode")
	private Integer episode;

	public long getId() {
		return id;
	}

	@OneToMany
	private List<Pilots> pilots;
	
	
	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

}
