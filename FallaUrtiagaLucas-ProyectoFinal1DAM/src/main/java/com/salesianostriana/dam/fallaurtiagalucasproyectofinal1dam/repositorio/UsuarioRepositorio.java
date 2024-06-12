package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findFirstByUsername(String username);
	
	//Filtrar libros Favoritos de un usuario.
	@Query("""
			SELECT u.listadoFavoritos 
			FROM Usuario u
			""")
	public List<Libro> findLibroByFavorito();
	
}
