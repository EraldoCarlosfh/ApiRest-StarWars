package com.starwars.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starwars.apirest.models.Starships;

public interface StarshipsRepository extends JpaRepository<Starships, Long> {
	
	Starships findById(long id);

}
