package com.DAW.practicaspring.controller;

import com.DAW.practicaspring.model.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();

    public TareaController() {
        tareas.add(new Tarea(1L, "Estudiar Spring Boot", false));
        tareas.add(new Tarea(2L, "Hacer práctica REST", true));
    }


    @GetMapping
    public List<Tarea> obtenerTodas() {
        return tareas;
    }

    @GetMapping("/{id}")
    public Tarea obtenerPorId(@PathVariable Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea nueva) {
        tareas.add(nueva);
        return nueva;
    }


    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareas.removeIf(t -> t.getId().equals(id));
    }
}
