package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio.LibroRepositorio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.base.ServicioBaseImpl;

@Service
public class LibroServicio extends ServicioBaseImpl<Libro, Long, LibroRepositorio>{

	@Autowired
	private LibroRepositorio repoLibro;
	
	public List<Libro>filtrarLibroPorTipo(Long idTipo){
		List<Libro> librosFiltradosPorIdTipo = repoLibro.findLibroByTipoId(idTipo);
		
		return librosFiltradosPorIdTipo;
	}
	
	
	
	
	
}
