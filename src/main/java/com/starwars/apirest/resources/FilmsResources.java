package com.starwars.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.apirest.models.Films;
import com.starwars.apirest.repository.FilmsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Films")
@CrossOrigin(origins="*")
public class FilmsResources {
	
	@Autowired
	FilmsRepository filmsRepository;
	
	@GetMapping(value="/films", produces="application/json")
	@ApiOperation(value="Return all films")
	public List<Films> getAllFilms(){
		return filmsRepository.findAll();
	}
	
	@GetMapping(value="/films/{id}", produces="application/json")
	@ApiOperation(value="Return only one film")
	public Films getFilmById(@PathVariable(value="id") long id){
		return filmsRepository.findById(id);
	}
	
	@PostMapping(value="/save/films", produces="application/json")
	@ApiOperation(value="Save a film")
	public Films saveFilm(@RequestBody Films film){
		return filmsRepository.save(film);
	}
	
	@DeleteMapping(value="/delete/films/{id}", produces="application/json")
	@ApiOperation(value="Delete a film by Id")
	public void deleteFilmById(@PathVariable(value="id") long id){
		filmsRepository.deleteById(id);
	}
	
	@PutMapping(value="/update/films/{id}/{episode}/{title}", produces="application/json")
	@ApiOperation(value="Update a film")
	public Films updateFilms(@PathVariable(value="id") long id, @RequestParam(value="episode") Integer episode, @RequestParam(value="title") String title) {
	  Films film = filmsRepository.findById(id);	
	  if (film != null) {
	    film.updateFilme(episode, title);
	    return filmsRepository.save(film);
	  }
	  return film;
	}
}
