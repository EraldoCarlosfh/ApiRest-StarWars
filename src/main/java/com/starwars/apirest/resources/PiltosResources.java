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
import com.starwars.apirest.models.Pilots;
import com.starwars.apirest.models.Starships;
import com.starwars.apirest.repository.PilotsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Pilots")
@CrossOrigin(origins="*")
public class PiltosResources {
	
	@Autowired
	PilotsRepository pilotsRepository;
	
	@GetMapping(value="/pilots", produces="application/json")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Return all pilots"),
		    @ApiResponse(code = 403, message = "You do not have permission to access this feature"),
		    @ApiResponse(code = 500, message = "An exception was generated "),
		})
	@ApiOperation(value="Return all pilots")
	public List<Pilots> getAllPilots(){
		return pilotsRepository.findAll();
	}
	
	@GetMapping(value="/pilots/{id}", produces="application/json")
	@ApiOperation(value="Returns only one pilot")
	public Pilots getPilotById(@PathVariable(value="id") long id){
		return pilotsRepository.findById(id);
	}
	
	@PostMapping(value="/save/pilots", produces="application/json")
	@ApiOperation(value="Save a pilot")
	public Pilots savePilot(@RequestBody Pilots pilot){
		return pilotsRepository.save(pilot);
	}
		
	@DeleteMapping(value="/delete//pilots/{id}", produces="application/json")
	@ApiOperation(value="Delete a pilot by Id")
	public void deletePilotById(@PathVariable(value="id") long id){
		pilotsRepository.deleteById(id);
	}
	
	@PutMapping(value="/update/pilots/{id}", produces="application/json")
	@CrossOrigin(origins="*")
	@ApiOperation(value="Update a pilot")
	public Pilots updatePilots(@RequestBody Pilots pilot, @PathVariable("id") Integer id) {
	  Pilots pilotEdit = pilotsRepository.findById(id);	
	  if (pilotEdit != null) {
		  pilotEdit.updatePilot(pilot);
	    return pilotsRepository.save(pilotEdit);
	  }
	  return pilotEdit;
	}
}
