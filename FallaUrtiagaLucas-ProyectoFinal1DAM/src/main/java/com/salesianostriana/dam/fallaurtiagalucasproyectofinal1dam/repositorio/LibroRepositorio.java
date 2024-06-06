package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Tipo;

public interface LibroRepositorio extends JpaRepository<Libro, Long>{

	/*public List<Libro> findByCategoria(Categoria categoria);*/
	
	
	@Query("""
			SELECT l
			FROM Libro l
			""")
	public List<Long> findLibrosIds();

//--- CONSULTAS TIPO Y CATEGORÍA ----------------------------------------------------------------------------------------------
	
	//Número de tipos que hay.
	@Query("""
			SELECT count(*)
			FROM Tipo
			""")
	public int findNumTipos();
		
	
	//Número de categorías que hay.
	@Query("""
			SELECT count(*)
			FROM Categoria
			""")
	public int findNumCategorias();
	
	
	//Filtrar los libros por tipo (Se emplea para el filtro del catálogo).
	@Query("""
			SELECT l
			FROM Libro l
			WHERE l.tipo.idTipo = :tipo
			""")
	public List<Libro> findLibroByTipoId(@Param("tipo") Long idTipo);
	
	
	//Filtrar los libros por categoría (Se emplea para el filtro del catálogo).
	@Query("""
			SELECT l
			FROM Libro l
				JOIN l.listadoCategorias c
			WHERE c.idCategoria = :categoria
			""")
	public List<Libro> findLibroByCategoriaId(@Param("categoria") Long idCategoria);
	
	
	//Número de libros que tiene un tipo (Se emplea para comprobar si se puede borrar un tipo o no).
	@Query("""
			SELECT count(l)
			FROM Libro l
			WHERE tipo.idTipo = :tipo
			""")
	public int findNumLibrosByTipo(@Param("tipo") Long idTipo);
	
	
	//Número de libros que tiene una categoría (Se emplea para comprobar si se puede borrar una categoría o no).
	@Query("""
			SELECT count(l)
			FROM Libro l 
				JOIN l.listadoCategorias c
			WHERE c.idCategoria = :categoria
			""")
	public int findNumLibrosByCategoria(@Param("categoria") Long idCategoria);
	
//-----------------------------------------------------------------------------------------------------------------------------
	
	//Filtrar los libros por serie (Se emplea para ver todos los productos de una serie de libros).
	@Query("""
			SELECT l
			FROM Libro l
			WHERE l.serie = :serie
			""")
	public List<Libro> findLibroBySerie(@Param("serie") String serie);
	
	
	//Filtro de Novedades (Aquellos productos que hayan pasado menos de 21 días desde su publicación son considerados nuevos).
	@Query("""
			SELECT l 
			FROM Libro l
			WHERE l.fechaPublicacion >= ?1
			""")
	public List<Libro> librosPosterioresAUnaFecha(LocalDateTime fechaPublicacion);
	
	
	//Filtro de Próximamente (Aquellos productos cuya fecha de publicación sea superior a la fecha actual).
	@Query("""
			SELECT l 
			FROM Libro l
			WHERE l.fechaPublicacion > current_date
			""")
	public List<Libro> findLibroByFechaPublicacion();
	
	
	
}
