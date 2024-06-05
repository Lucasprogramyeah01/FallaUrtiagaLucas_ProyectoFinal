package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Tipo;

public interface LibroRepositorio extends JpaRepository<Libro, Long>{

	/*public List<Libro> findByCategoria(Categoria categoria);*/
	
	/*@Query("""
			SELECT l FROM Libro l
			WHERE l.fechaPublicacion <= '21day'::interval
			""")
	List<Libro> librosNuevos(@Param("fechaPublicacion") LocalDateTime fechaPublicacion);*/
	
	
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
	/*@Query("""
			SELECT count(l)
			FROM Libro l JOIN Categoria c ON (
			WHERE l.idTipo = :tipo
			""")
	public int findNumLibrosByCategoria(@Param("tipo") Long idTipo);*/
	
	
}
