package com.utn.apirest1.repositories;

import com.utn.apirest1.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {

    // Anotación Método de Query
    List<Localidad> findByDenominacionContaining(String denominacion);
    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);

    // Anotación JPQL parámetros indexados
    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE '%?1%'")
    List<Localidad> search(String filtro);

    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE '%?1%'")
    Page<Localidad> search(String filtro, Pageable pageable);

    // Anotación JPQL parámetros nombrados
    /*@Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE '%:filtro%'")
    Page<Localidad> search(@Param("filtro") String filtro, Pageable pageable);*/

    // Anotación Query Nativo
    /*@Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE '%:filtro%'",
            countQuery = "SELECT count(*) FROM localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNativo(@Param("filtro") String filtro, Pageable pageable);*/
}
