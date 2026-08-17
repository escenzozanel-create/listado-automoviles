package com.autos.web.Controller;

import com.autos.web.Entity.Automovil;
import com.autos.web.Service.AutomovilService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AutomovilController {

    private final AutomovilService automovilService;

    public AutomovilController(AutomovilService automovilService) {
        this.automovilService = automovilService;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/automoviles";
    }

    @GetMapping("/automoviles")
    public String listarAutomoviles(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String clase,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false, defaultValue = "false") boolean filtrar,
            Model model) {

        OpcionesFiltro opciones = filtrar
                ? obtenerOpciones(marca, modelo, clase, color, anio)
                : obtenerOpciones(null, null, null, null, null);

        List<Automovil> automoviles = filtrar
                ? automovilService.filtrarAutomoviles(
                        opciones.marcaSeleccionada(),
                        opciones.modeloSeleccionado(),
                        opciones.claseSeleccionada(),
                        opciones.colorSeleccionado(),
                        opciones.anioSeleccionado())
                : automovilService.listarTodos();

        model.addAttribute("automoviles", automoviles);

        model.addAttribute("marcas", opciones.marcas());
        model.addAttribute("modelos", opciones.modelos());
        model.addAttribute("clases", opciones.clases());
        model.addAttribute("colores", opciones.colores());
        model.addAttribute("anios", opciones.anios());

        model.addAttribute("marcaSeleccionada", opciones.marcaSeleccionada());
        model.addAttribute("modeloSeleccionado", opciones.modeloSeleccionado());
        model.addAttribute("claseSeleccionada", opciones.claseSeleccionada());
        model.addAttribute("colorSeleccionado", opciones.colorSeleccionado());
        model.addAttribute("anioSeleccionado", opciones.anioSeleccionado());
        model.addAttribute("filtrar", filtrar);

        return "automoviles";
    }

    @GetMapping("/automoviles/opciones")
    @ResponseBody
    public OpcionesFiltro opcionesFiltros(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String clase,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer anio) {

        return obtenerOpciones(marca, modelo, clase, color, anio);
    }

    @GetMapping("/automoviles/resultados")
    @ResponseBody
    public List<AutomovilRespuesta> resultadosFiltrados(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String clase,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer anio) {

        OpcionesFiltro opciones = obtenerOpciones(marca, modelo, clase, color, anio);

        return automovilService
                .filtrarAutomoviles(
                        opciones.marcaSeleccionada(),
                        opciones.modeloSeleccionado(),
                        opciones.claseSeleccionada(),
                        opciones.colorSeleccionado(),
                        opciones.anioSeleccionado())
                .stream()
                .map(AutomovilRespuesta::desde)
                .toList();
    }

    private OpcionesFiltro obtenerOpciones(String marca, String modelo, String clase, String color, Integer anio) {
        String marcaValida = normalizarTexto(marca);
        String modeloValido = normalizarTexto(modelo);
        String claseValida = normalizarTexto(clase);
        String colorValido = normalizarTexto(color);

        List<String> marcas = automovilService.listarMarcas();
        if (!contiene(marcas, marcaValida)) {
            marcaValida = null;
        }

        List<String> modelos = automovilService.listarModelos(marcaValida);
        if (!contiene(modelos, modeloValido)) {
            modeloValido = null;
        }

        List<String> clases = automovilService.listarClases(marcaValida, modeloValido);
        if (!contiene(clases, claseValida)) {
            claseValida = null;
        }

        List<String> colores = automovilService.listarColores(marcaValida, modeloValido, claseValida);
        if (!contiene(colores, colorValido)) {
            colorValido = null;
        }

        List<Integer> anios = automovilService.listarAnios(marcaValida, modeloValido, claseValida, colorValido);
        Integer anioValido = anios.contains(anio) ? anio : null;

        return new OpcionesFiltro(
                marcas,
                modelos,
                clases,
                colores,
                anios,
                marcaValida,
                modeloValido,
                claseValida,
                colorValido,
                anioValido);
    }

    private String normalizarTexto(String valor) {
        return valor == null || valor.isBlank() ? null : valor;
    }

    private boolean contiene(List<String> opciones, String seleccion) {
        return seleccion != null && opciones.contains(seleccion);
    }

    public record OpcionesFiltro(
            List<String> marcas,
            List<String> modelos,
            List<String> clases,
            List<String> colores,
            List<Integer> anios,
            String marcaSeleccionada,
            String modeloSeleccionado,
            String claseSeleccionada,
            String colorSeleccionado,
            Integer anioSeleccionado) {
    }

    public record AutomovilRespuesta(
            Long id,
            String marca,
            String modelo,
            String clase,
            String color,
            Integer anio,
            Double precio) {

        public static AutomovilRespuesta desde(Automovil automovil) {
            return new AutomovilRespuesta(
                    automovil.getId(),
                    automovil.getMarca(),
                    automovil.getModelo(),
                    automovil.getClase(),
                    automovil.getColor(),
                    automovil.getAnio(),
                    automovil.getPrecio());
        }
    }
}
