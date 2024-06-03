package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Categoria;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Long>{

	/*public List<Libro> findByCategoria(Categoria categoria);*/
	
	/*@Query("""
			SELECT l FROM Libro l
			WHERE l.fechaPublicacion <= '21day'::interval
			""")
	List<Libro> librosNuevos(@Param("fechaPublicacion") LocalDateTime fechaPublicacion);*/
	
	/*@Query("""
			SELECT l
			FROM Libro l
			WHERE l.listadoCategoria.Categoria.idCategoria =: categoriaId
			""")
	public List<Libro> findByCategoriaId(@Param("categoriaId") Long categoriaId);*/
	
	
	
	
}
