package com.starwars.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starwars.apirest.models.Pilots;
import com.starwars.apirest.models.Starships;

public interface PilotsRepository extends JpaRepository<Pilots, Long> {
	
	Pilots findById(long id);

}
