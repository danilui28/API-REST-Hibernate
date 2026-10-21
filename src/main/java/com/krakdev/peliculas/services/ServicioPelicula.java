package com.krakdev.peliculas.services;

import org.springframework.stereotype.Service;

import com.krakdev.peliculas.entidades.Pelicula;
import com.krakdev.peliculas.repository.PeliculaRepository;
import java.util.List;

@Service
public class ServicioPelicula {

	private final PeliculaRepository peliculaRepository;

	public ServicioPelicula(PeliculaRepository peliculaRepository) {
		this.peliculaRepository = peliculaRepository;
	}

	public Pelicula crear(Pelicula pelicula) {
		return peliculaRepository.save(pelicula);
	}

	public List<Pelicula> listar() {
		return peliculaRepository.findAll();
	}

	public Pelicula buscarPorId(Long id) {
		return peliculaRepository.findById(id).orElse(null);
	}

	public Pelicula actualizar(Long id, Pelicula datos) {

		Pelicula pelicula = buscarPorId(id);

		if (pelicula == null) {
			return null;
		}

		pelicula.setNombre(datos.getNombre());
		pelicula.setDirector(datos.getDirector());
		pelicula.setGenero(datos.getGenero());
		pelicula.setDuracion(datos.getDuracion());
		pelicula.setDisponible(datos.isDisponible());
		pelicula.setCalificacion(datos.getCalificacion());

		return peliculaRepository.save(pelicula);
	}

	public boolean eliminar(Long id) {

		if (!peliculaRepository.existsById(id)) {
			return false;
		}

		peliculaRepository.deleteById(id);

		return true;
	}
	
	public List<Pelicula> buscarPorGenero(String genero) {
		return peliculaRepository.findByGenero(genero);
	}

	public List<Pelicula> buscarPorDisponible(boolean disponible) {
		return peliculaRepository.findByDisponible(disponible);
	}
}
