package com.utn.apirest1.repositories;

import com.utn.apirest1.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {

    // Anotación Método de Query
    List<Autor> findByNombreContainingOrApellidoContainingOrBiografiaContaining(String nombre, String apellido, String biografia);
    Page<Autor> findByNombreContainingOrApellidoContainingOrBiografiaContaining(String nombre, String apellido, String biografia, Pageable pageable);

    // Anotación JPQL parámetros indexados
    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE '%?1%' OR a.apellido LIKE '%?1%' OR a.biografia LIKE '%?1%'")
    List<Autor> search(String filtro);

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE '%?1%' OR a.apellido LIKE '%?1%' OR a.biografia LIKE '%?1%'")
    Page<Autor> search(String filtro, Pageable pageable);

    // Anotación JPQL parámetros nombrados
    /*@Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE '%:filtro%' OR a.apellido LIKE '%:filtro%' OR a.biografia LIKE '%?1%'")
    Page<Autor> search(@Param("filtro") String filtro, Pageable pageable);*/

    // Anotación Query Nativo
    /*@Query(
            value = "SELECT * FROM autor WHERE autor.nombre LIKE '%:filtro%' OR autor.apellido LIKE '%:filtro%' OR autor.biografia LIKE '%:filtro%'",
            countQuery = "SELECT count(*) FROM autor",
            nativeQuery = true
    )
    Page<Autor> searchNativo(@Param("filtro") String filtro, Pageable pageable);*/
}
