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
	
	//Encontrar IDs de libros.
	@Query("""
			SELECT l
			FROM Libro l
			""")
	public List<Long> findLibrosIds();
	
	
	//Ordenar libros de forma aleatoria con límite 15.
	@Query("""
			SELECT l
			FROM Libro l
			ORDER BY RAND()
			LIMIT 15
			""")
	public List<Libro> findLibrosByRandomOrderAndLimit15();
	
	
	//Ordenar libros de forma aleatoria.
	@Query("""
			SELECT l
			FROM Libro l
			ORDER BY RAND()
			""")
	public List<Libro> findLibrosByRandomOrder();
		
	
	//Filtrar libros por palabra clave.
	@Query("""
			SELECT l
			FROM Libro l
			WHERE l.titulo ILIKE %?1%
				OR l.serie ILIKE %?1%
				OR l.autor ILIKE %?1%
				OR l.editorial ILIKE %?1%
				ORDER BY RAND()
			""")
	public List<Libro> findLibrosByPalabraClave(String palabraClave);

	
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
			ORDER BY RAND()
			""")
	public List<Libro> findLibroByTipoId(@Param("tipo") Long idTipo);
	
	
	//Filtrar los libros por categoría (Se emplea para el filtro del catálogo).
	@Query("""
			SELECT l
			FROM Libro l
				JOIN l.listadoCategorias c
			WHERE c.idCategoria = :categoria
			ORDER BY RAND()
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
			WHERE l.fechaPublicacion BETWEEN ?1 AND ?2
			ORDER BY RAND()
			""")
	public List<Libro> librosPosterioresAUnaFecha(LocalDateTime fecha, LocalDateTime hoy);
	
	
	//Filtro de Próximamente (Aquellos productos cuya fecha de publicación sea superior a la fecha actual).
	@Query("""
			SELECT l 
			FROM Libro l
			WHERE l.fechaPublicacion > current_date
			ORDER BY RAND()
			""")
	public List<Libro> findLibroByFechaPublicacion();
	
	
	
}
