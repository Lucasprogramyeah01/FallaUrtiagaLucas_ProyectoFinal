package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.LineaVenta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Venta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio.VentaRepositorio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.base.ServicioBaseImpl;

@Service
public class VentaServicio extends ServicioBaseImpl<Venta, Long, VentaRepositorio>{

	@Autowired
	private VentaRepositorio repoVenta;
	
//---------------------------------------------------------------------------------------------------------------------
	
	//Comprobar si hay productos en la cesta.
	public boolean hayProductoEnCesta(Usuario u, Libro l){
		return repoVenta.findIfExistsProductoInCesta(u, l);
	}
	
	
	//Obtener una venta sin finalizar.
	public Optional <Venta> obtenerVentaSinFinalizar(Usuario u){
		return repoVenta.findVentaByFinalizadaFalse(u);
	}
	
	
	//Comprobar si exista una venta sin finalizar.
	public boolean existeVentaSinFinalizar(Usuario u){
		return repoVenta.findIfExistsVentaFinalizadaFalse(u);
	}

//---------------------------------------------------------------------------------------------------------------------
	
	//Obtener LineaVenta por libro (para cesta).
	public Optional<LineaVenta> obtenerLineaVentaPorLibro(Usuario u, Libro l) {
		return repoVenta.findLineaVentaByLibro(u, l);
	}
	
}
