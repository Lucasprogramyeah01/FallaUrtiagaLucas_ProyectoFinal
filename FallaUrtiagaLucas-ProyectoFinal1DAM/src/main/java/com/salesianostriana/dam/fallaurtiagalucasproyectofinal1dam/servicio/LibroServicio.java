package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio;

import java.time.LocalDateTime;
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
	public List<Libro> filtrarLibroPorTipo(Long idTipo){
		List<Libro> librosFiltradosPorIdTipo = repoLibro.findLibroByTipoId(idTipo);
		
		return librosFiltradosPorIdTipo;
	}
	
	
	//Filtrar por Categoría.
	public List<Libro> filtrarLibroPorCategoria(Long idCategoria){
		List<Libro> librosFiltradosPorIdCategoria = repoLibro.findLibroByCategoriaId(idCategoria);
		
		return librosFiltradosPorIdCategoria;
	}

	
	//Obtener el número de libros de un tipo.
	public int numeroLibrosDeUnTipo (Long idTipo) {
		return repoLibro.findNumLibrosByTipo(idTipo);
	}
	
	
	//Obtener el número de libros de una categoría.
	public int numeroLibrosDeUnaCategoria (Long idCategoria) {
		return repoLibro.findNumLibrosByCategoria(idCategoria);
	}
	
	
	//Filtrar por Serie.
	public List<Libro> filtrarLibrosPorSerie(String nombre){
		List<Libro> librosFiltradosPorSerie = repoLibro.findLibroBySerie(nombre);
				
		return librosFiltradosPorSerie;
	}
	
	
	/*Filtrar libros posteriores a una fecha y comparar si con respecto a la fecha de publicación 
	 * de dichos libros hay un intervalo de 21 días.*/
	public List<Libro> librosNuevos() {
		return repoLibro.librosPosterioresAUnaFecha(LocalDateTime.now().minusDays(21), LocalDateTime.now());
	}
	
	
	//Filtrar por Fecha de publicación.
	public List<Libro> filtrarLibrosPorFechaPublicacion(){
		List<Libro> librosFiltradosPorFechaPub = repoLibro.findLibroByFechaPublicacion();
					
		return librosFiltradosPorFechaPub;
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
	
	
}
