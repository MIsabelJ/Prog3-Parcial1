package com.utn.apirest1.repositories;

import com.utn.apirest1.entities.Autor;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
}
