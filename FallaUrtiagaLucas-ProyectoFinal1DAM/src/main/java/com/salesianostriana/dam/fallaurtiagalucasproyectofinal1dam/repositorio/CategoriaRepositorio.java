package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

	/*@Query("""
			SELECT count(l)
			FROM Libro l
			WHERE l.
			""")
	public int findNumProductosByCategoria(Categoria categoria);*/
}
