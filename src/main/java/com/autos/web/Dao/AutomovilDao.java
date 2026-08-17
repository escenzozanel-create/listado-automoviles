package com.autos.web.Dao;

import com.autos.web.Entity.Automovil;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomovilDao extends JpaRepository<Automovil, Long> {

    @Query("""
            SELECT a FROM Automovil a
            WHERE (:marca IS NULL OR :marca = '' OR a.marca = :marca)
              AND (:modelo IS NULL OR :modelo = '' OR a.modelo = :modelo)
              AND (:clase IS NULL OR :clase = '' OR a.clase = :clase)
              AND (:color IS NULL OR :color = '' OR a.color = :color)
              AND (:anio IS NULL OR a.anio = :anio)
            ORDER BY a.id ASC
            """)
    List<Automovil> filtrarAutomoviles(
            String marca,
            String modelo,
            String clase,
            String color,
            Integer anio);

    @Query("SELECT DISTINCT a.marca FROM Automovil a WHERE a.marca IS NOT NULL ORDER BY a.marca")
    List<String> listarMarcas();

    @Query("""
            SELECT DISTINCT a.modelo FROM Automovil a
            WHERE a.modelo IS NOT NULL
              AND (:marca IS NULL OR :marca = '' OR a.marca = :marca)
            ORDER BY a.modelo
            """)
    List<String> listarModelos(String marca);

    @Query("""
            SELECT DISTINCT a.clase FROM Automovil a
            WHERE a.clase IS NOT NULL
              AND (:marca IS NULL OR :marca = '' OR a.marca = :marca)
              AND (:modelo IS NULL OR :modelo = '' OR a.modelo = :modelo)
            ORDER BY a.clase
            """)
    List<String> listarClases(String marca, String modelo);

    @Query("""
            SELECT DISTINCT a.color FROM Automovil a
            WHERE a.color IS NOT NULL
              AND (:marca IS NULL OR :marca = '' OR a.marca = :marca)
              AND (:modelo IS NULL OR :modelo = '' OR a.modelo = :modelo)
              AND (:clase IS NULL OR :clase = '' OR a.clase = :clase)
            ORDER BY a.color
            """)
    List<String> listarColores(String marca, String modelo, String clase);

    @Query("""
            SELECT DISTINCT a.anio FROM Automovil a
            WHERE a.anio IS NOT NULL
              AND (:marca IS NULL OR :marca = '' OR a.marca = :marca)
              AND (:modelo IS NULL OR :modelo = '' OR a.modelo = :modelo)
              AND (:clase IS NULL OR :clase = '' OR a.clase = :clase)
              AND (:color IS NULL OR :color = '' OR a.color = :color)
            ORDER BY a.anio DESC
            """)
    List<Integer> listarAnios(String marca, String modelo, String clase, String color);
}
