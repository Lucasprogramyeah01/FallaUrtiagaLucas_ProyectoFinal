package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.LineaVenta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Venta;

public class CestaServicio {

	@Autowired
	private VentaServicio servicioVenta;
	
	
	//ACLARACIÓN: Una Cesta es una venta sin finalizar por cada Usuario.

//---------------------------------------------------------------
	
	//CREAR CESTA.
	public Venta crearCesta(Usuario u) {
		Venta cesta = new Venta();
		
		return cesta;
	}
	
	//OBTENER CESTA.
	public Venta obtenerCesta(Usuario u){
		return servicioVenta.obtenerVentaSinFinalizar(u).orElseGet(() -> crearCesta(u));
	}
	
	//OBTENER LINEA DE VENTA POR LIBRO.
	private Optional <LineaVenta> obtenerLineaVentaPorLibro(Usuario u, Libro l) {
		Venta cesta = obtenerCesta(u);
				
		return cesta.getListadoLineaVenta().stream().filter(lv -> lv.getLibro().getIdLibro() == l.getIdLibro()).findFirst();
	}
	
	//CALCULAR EL PRECIO FINAL DE LA VENTA.
    public double calcularPrecioFinal(Usuario u){
    	return obtenerCesta(u).getListadoLineaVenta().stream().mapToDouble(LineaVenta::calcularSubtotalLineaVenta).sum();
    }
		
//---------------------------------------------------------------
	
	//AÑADIR PRODUCTO A LA CESTA.
    public void agregarProducto(Usuario u, Libro l, int cantidad){ 
    	Venta cesta = obtenerCesta(u);
    	
    	if(!servicioVenta.hayProductoEnCesta(u, l)){
    		cesta.agregarLineaVenta(LineaVenta.builder().libro(l).cantidad(cantidad).build());
    	}else{
    		Optional<LineaVenta> lv = servicioVenta.obtenerLineaVentaPorLibro(u, l);

	        if(lv.isPresent()){
	          modificarCantidad(u, l, lv.get().getCantidad()+1);
	        }
    	}

      servicioVenta.edit(cesta);
    }
	
	//MODIFICAR PRODUCTO DE LA CESTA.
	public void modificarCantidad(Usuario u, Libro l, int cantidad){
		Venta cesta = obtenerCesta(u);

		if(cantidad <= 0){
			eliminarProducto(u, l);
	    }else{
	    	Optional <LineaVenta> lineaVentaAModificar = servicioVenta.obtenerLineaVentaPorLibro(u, l);

		    if(lineaVentaAModificar.isPresent()){
		    	LineaVenta lv = lineaVentaAModificar.get();
		    	lv.setCantidad(cantidad);
		    	
		        servicioVenta.edit(cesta);
		    }else{
		        agregarProducto(u, l, cantidad);
		    }
	    }
	}
	
	//ELIMINAR PRODUCTO DE LA CESTA.
	public void eliminarProducto(Usuario u, Libro l){
		Venta cesta = obtenerCesta(u);

		Optional<LineaVenta> LineaVentaAEliminar = servicioVenta.obtenerLineaVentaPorLibro(u, l);

		if(LineaVentaAEliminar.isPresent()){
			cesta.borrarLineaVenta(LineaVentaAEliminar.get());
			
			servicioVenta.edit(cesta);
		}
	}

	//FINALIZAR COMPRA.
	public void finalizarCompra (Usuario u){
		Venta cesta = obtenerCesta(u);

		cesta.setFinalizada(true);
		cesta.setFechaVenta(LocalDateTime.now());
		
		cesta.setPrecioFinal(calcularPrecioFinal(u));

		servicioVenta.edit(cesta);
	}
	
    //OBTENER PRODUCTOS EN LA CESTA.
    public Map<Libro, Integer> obtenerProductosEnCesta (Usuario u){
    	return obtenerCesta(u).getListadoLineaVenta().stream().collect(Collectors.toMap(lv -> lv.getLibro(), lv -> lv.getCantidad()));
    }
	
}
