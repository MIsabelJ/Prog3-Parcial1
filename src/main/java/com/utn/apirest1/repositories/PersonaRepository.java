package com.utn.apirest1.repositories;

import com.utn.apirest1.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
}
