package com.starwars.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starwars.apirest.models.Films;

public interface FilmsRepository extends JpaRepository<Films, Long> {
	
	Films findById(long id);
}
