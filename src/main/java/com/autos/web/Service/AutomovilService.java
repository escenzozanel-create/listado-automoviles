package com.autos.web.Service;

import com.autos.web.Entity.Automovil;
import java.util.List;

public interface AutomovilService {

    List<Automovil> listarTodos();

    List<Automovil> filtrarAutomoviles(
            String marca,
            String modelo,
            String clase,
            String color,
            Integer anio);

    List<String> listarMarcas();

    List<String> listarModelos(String marca);

    List<String> listarClases(String marca, String modelo);

    List<String> listarColores(String marca, String modelo, String clase);

    List<Integer> listarAnios(String marca, String modelo, String clase, String color);
}
