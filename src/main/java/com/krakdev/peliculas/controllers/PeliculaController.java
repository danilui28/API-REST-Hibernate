package com.krakdev.peliculas.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

	private final ServicioPelicula servicioPelicula;

	public PeliculaController(ServicioPelicula servicioPelicula) {
		this.servicioPelicula = servicioPelicula;
	}

	@PostMapping
	public ResponseEntity<Pelicula> crear(
			@RequestBody Pelicula pelicula) {

		Pelicula creada = servicioPelicula.crear(pelicula);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(creada);
	}

	@GetMapping
	public ResponseEntity<List<Pelicula>> listar() {

		List<Pelicula> peliculas = servicioPelicula.listar();

		return ResponseEntity.ok(peliculas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pelicula> buscarPorId(
			@PathVariable Long id) {

		Pelicula pelicula = servicioPelicula.buscarPorId(id);

		if (pelicula == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(pelicula);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pelicula> actualizar(
			@PathVariable Long id,
			@RequestBody Pelicula pelicula) {

		Pelicula actualizada =
				servicioPelicula.actualizar(id, pelicula);

		if (actualizada == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(actualizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(
			@PathVariable Long id) {

		boolean eliminado = servicioPelicula.eliminar(id);

		if (!eliminado) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/genero")
	public ResponseEntity<List<Pelicula>> buscarPorGenero(
			@RequestParam String genero) {

		List<Pelicula> peliculas =
				servicioPelicula.buscarPorGenero(genero);

		return ResponseEntity.ok(peliculas);
	}

	@GetMapping("/disponible")
	public ResponseEntity<List<Pelicula>> buscarPorDisponible(
			@RequestParam boolean disponible) {

		List<Pelicula> peliculas =
				servicioPelicula.buscarPorDisponible(disponible);

		return ResponseEntity.ok(peliculas);
	}

}