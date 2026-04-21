package com.sena.Api_SpringBoot.controller;

import com.sena.Api_SpringBoot.entity.Libro;
import com.sena.Api_SpringBoot.repository.LibroRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin("*")
public class LibroController {

    private final LibroRepository repository;

    public LibroController(LibroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Map<String, String> home() {
        return Map.of("message", "API Spring Boot funcionando");
    }

    @GetMapping("/libros")
    public List<Libro> getAll() {
        return repository.findAll();
    }

    @GetMapping("/libros/{id}")
    public Libro getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/libros")
    public Libro create(@RequestBody Libro libro) {
        return repository.save(libro);
    }

    @PutMapping("/libros/{id}")
    public Libro update(@PathVariable Long id, @RequestBody Libro libro) {
        Libro existing = repository.findById(id).orElseThrow();
        existing.setTitulo(libro.getTitulo());
        existing.setAutor(libro.getAutor());
        existing.setIsbn(libro.getIsbn());
        existing.setDisponible(libro.getDisponible());
        return repository.save(existing);
    }

    @DeleteMapping("/libros/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return Map.of("message", "Libro eliminado");
    }
}
