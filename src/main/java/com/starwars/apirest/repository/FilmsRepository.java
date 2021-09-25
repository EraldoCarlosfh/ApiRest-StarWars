package com.starwars.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starwars.apirest.models.Films;
import com.starwars.apirest.models.Starships;

public interface FilmsRepository extends JpaRepository<Films, Long> {
	
	Films findById(long id);

}
