package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.LineaVenta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Venta;

public interface VentaRepositorio extends JpaRepository<Venta, Long>{

//---------------------------------------------------------------------------------------------------------------------	
	
	//Comprobar si hay productos en la cesta.
	@Query("""
			SELECT
				CASE WHEN count(v) > 0
					THEN true 
					ELSE false 
				END
			FROM Venta v LEFT JOIN v.listadoLineaVenta lv
			WHERE v.usuario = ?1 
				AND lv.libro = ?2 
				AND v.finalizada = false
			""")
	public boolean findIfExistsProductoInCesta(Usuario u, Libro l);
	
	
	//Obtener una venta sin finalizar.
	@Query("""
			SELECT v
			FROM Venta v
			WHERE v.finalizada = false
				AND v.usuario = ?1
			""")
	public Optional <Venta> findVentaByFinalizadaFalse(Usuario u);
	
	
	//Comprobar si existe una venta sin finalizar.
	@Query("""
			SELECT v
			FROM Venta v
			WHERE v.finalizada = false
				AND v.usuario = ?1
			""")
	public boolean findIfExistsVentaFinalizadaFalse(Usuario u);
	
//---------------------------------------------------------------------------------------------------------------------
	
	//Obtener LineaVenta por libro (para cesta).
	@Query("""
			SELECT lv
			FROM Venta v LEFT JOIN v.listadoLineaVenta lv 
				JOIN lv.libro l
			WHERE v.usuario = ?1
				AND l.idLibro = ?2
				AND v.finalizada = false
			""")
	public Optional<LineaVenta> findLineaVentaByLibro(Usuario u, Libro l);
	
	
	
	
	
	
}
