package com.sena.Api_SpringBoot.repository;

import com.sena.Api_SpringBoot.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
