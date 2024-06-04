package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Tipo;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio.LibroRepositorio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.base.ServicioBaseImpl;

@Service
public class LibroServicio extends ServicioBaseImpl<Libro, Long, LibroRepositorio>{

	@Autowired
	private LibroRepositorio repoLibro;

	//Obtener el número de tipos.
	public int cantidadDeTipos () {
		return repoLibro.findNumTipos();
	}
	
	
	//Obtener el número de categorías.
	public int cantidadDeCategorias () {
		return repoLibro.findNumCategorias();
	}
	
	
	//Filtrar por Tipo.
	public List<Libro>filtrarLibroPorTipo(Long idTipo){
		List<Libro> librosFiltradosPorIdTipo = repoLibro.findLibroByTipoId(idTipo);
		
		return librosFiltradosPorIdTipo;
	}
	
	
	//Generar libros aleatorios.
	public List<Libro> generarLibrosAleatorios (int numLibrosAleatorios){
		List<Long> listaLibrosIds = repoLibro.findLibrosIds();
		
		Collections.shuffle(listaLibrosIds);	//Este método ordena la lista de forma aleatoria ¡Qué práctico!
		
		listaLibrosIds = listaLibrosIds.stream().limit(numLibrosAleatorios).collect(Collectors.toList());
		
		/*Se acaba de: coger la lista ordenada aleatoriamente, de los 200 productos que tiene se limita al
		 * número establecido por parámetro en la variable 'numLibrosAleatorios', y por último, esos productos
		 * seleccionados se guardan en una nueva lista ¡Qué practico!
		 */
		
		return repoLibro.findAllById(listaLibrosIds);
	}
	
	
	//Obtener el número de libros de un tipo.
	public int numeroLibrosDeUnTipo (Long idTipo) {
		return repoLibro.findNumLibrosByTipo(idTipo);
	}
	
	
}
