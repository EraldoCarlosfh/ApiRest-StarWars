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
import org.springframework.web.bind.annotation.RestController;

import com.starwars.apirest.models.Starships;
import com.starwars.apirest.repository.StarshipsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Starships")
@CrossOrigin(origins="*")
public class StarshipsResources {
	
	@Autowired
	StarshipsRepository starshipsRepository;
	
	@GetMapping(value="/starships", produces="application/json")
	@ApiOperation(value="Return all starships")
	public List<Starships> getAllStarships(){
		return starshipsRepository.findAll();
	}
	
	@GetMapping(value="/starship/{id}", produces="application/json")
	@ApiOperation(value="Return only one starship")
	public Starships getStarshipById(@PathVariable(value="id") long id){
		return starshipsRepository.findById(id);
	}
	
	@PostMapping(value="/save/starship", produces="application/json")
	@ApiOperation(value="Save a starship")
	public Starships saveStarship(@RequestBody Starships starship){
		return starshipsRepository.save(starship);
	}
	
	@DeleteMapping(value="/delete/starship", produces="application/json")
	@ApiOperation(value="Delete a starship")
	public void deleteStarship(@RequestBody Starships starship){
		starshipsRepository.delete(starship);
	}
	
	@DeleteMapping(value="/delete/starship/{id}", produces="application/json")
	@ApiOperation(value="Delete a starship by Id")
	public void deleteStarshipById(@PathVariable(value="id") long id){
		starshipsRepository.deleteById(id);
	}
	
	@PutMapping(value="/update/starship", produces="application/json")
	@ApiOperation(value="Update a starship")
	public Starships updateStarship(@RequestBody Starships starship){
		return starshipsRepository.save(starship);
	}

}
