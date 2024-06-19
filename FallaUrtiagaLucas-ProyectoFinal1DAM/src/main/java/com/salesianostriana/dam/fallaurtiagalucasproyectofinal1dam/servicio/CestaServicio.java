package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.text.LabelView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.LineaVenta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Venta;

@Service
public class CestaServicio {

	@Autowired
	private VentaServicio servicioVenta;
	
	
	//ACLARACIÓN: Una Cesta es una venta sin finalizar por cada Usuario.

//---------------------------------------------------------------
	
	//CREAR CESTA.
	public Venta crearCesta(Usuario u) {
		Venta cesta = Venta.builder().usuario(u).finalizada(false).listadoLineaVenta(new ArrayList<>()).gastosEnvio(3.95).build();
		
		servicioVenta.save(cesta);
		return cesta;
	}
	
	//OBTENER CESTA.
	public Venta obtenerCesta(Usuario u){
		return servicioVenta.obtenerVentaSinFinalizar(u).orElseGet(() -> crearCesta(u));
	}
	
	//OBTENER LINEA DE VENTA POR LIBRO.
	public Optional <LineaVenta> obtenerLineaVentaPorLibro(Usuario u, Libro l) {
		Venta cesta = obtenerCesta(u);
				
		return cesta.getListadoLineaVenta().stream().filter(lv -> lv.getLibro().getIdLibro().equals(l.getIdLibro())).findFirst();
	}
	
	//COMPROBAR SI HAY 3 MANGAS DE LA MISMA SERIE EN LA VENTA
	public boolean comprobarSiHay3MangasDeUnaMismaSerie(Usuario u) {
		Venta cesta = obtenerCesta(u);

		Map<String, Long> frecuenciasSeries = cesta.getListadoLineaVenta().stream().map(LineaVenta::getLibro).collect(Collectors.groupingBy(Libro::getSerie, Collectors.counting()));
		
		return frecuenciasSeries.entrySet().stream().anyMatch(e -> e.getValue() >= 3);

	}
	
//---------------------------------------------------------------
	
	//CALCULAR SUBTOTAL DE LA VENTA
	public double calcularSubtotalVenta(Usuario u) {
		double subtotalLV;
		
		Venta cesta = obtenerCesta(u);
		
		subtotalLV = cesta.getListadoLineaVenta().stream().mapToDouble(LineaVenta::calcularSubtotalLineaVenta).sum();
		
		if(comprobarSiHay3MangasDeUnaMismaSerie(u)) {
			cesta.setDescuentoFanSerie(true);
			
			return cesta.calcularDescuentoDeFanDeSerie(subtotalLV);
		}else {
			return subtotalLV;
		}
	}
	
	//CALCULAR EL PRECIO FINAL DE LA VENTA.
    public double calcularPrecioFinal(Usuario u){
    	
    	Venta cesta = obtenerCesta(u);
    	
    	cesta.setSubtotal(calcularSubtotalVenta(u));
    	
    	return cesta.calcularDescuentoEnvioGratuito() + /*calcularSubtotalVenta(u)*/ cesta.getSubtotal();
    	
    	/*return obtenerCesta(u).getListadoLineaVenta().stream().mapToDouble(LineaVenta::calcularSubtotalLineaVenta).sum();*/
    }
		
//---------------------------------------------------------------
	
	//AÑADIR PRODUCTO A LA CESTA.
    public void agregarProducto(Usuario u, Libro l /*int cantidad*/){ 
    	Venta cesta = obtenerCesta(u);
    	
    	if(!servicioVenta.hayProductoEnCesta(u, l)){
    		int cantidad = 1;
    		
    		l.setStock(l.getStock()-1);
    		
    		cesta.agregarLineaVenta(LineaVenta.builder().libro(l).cantidad(cantidad).subtotal(l.getPrecio()).venta(cesta).build());
    	}else{
    		Optional<LineaVenta> lv = obtenerLineaVentaPorLibro(u, l);

	        if(lv.isPresent()){
	          
	        	if(lv.get().getLibro().getStock() > 0) {
	        		l.setStock(l.getStock()-1);
	 	        	
	        		modificarCantidad(u, l, lv.get().getCantidad()+1);
	        	}else {
	        		modificarCantidad(u, l, lv.get().getCantidad());
	        	}
	         
	        }
    	}

      servicioVenta.edit(cesta);
    }
    
  //ELIMINAR PRODUCTO DE LA CESTA.
    public void eliminarProducto(Usuario u, Libro l, int cantidad) {
    	Venta cesta = obtenerCesta(u);
    	
    	if(cantidad <= 0){
			eliminarLineaDeVenta(u, l);
	    }else{
	    	Optional <LineaVenta> lineaVentaAModificar = obtenerLineaVentaPorLibro(u, l);

		    if(lineaVentaAModificar.isPresent()){
		    	
		    	if(lineaVentaAModificar.get().getCantidad() > 0) {
		    		l.setStock(l.getStock()+1);
		    		
		    		modificarCantidad(u, l, lineaVentaAModificar.get().getCantidad()-1);
		    	}
		    	
		    }

	    }
    	
    	 servicioVenta.edit(cesta);
    }
    
    
	//MODIFICAR PRODUCTO DE LA CESTA.
	public void modificarCantidad(Usuario u, Libro l, int cantidad){
		Venta cesta = obtenerCesta(u);

		if(cantidad <= 0){
			eliminarLineaDeVenta(u, l);
	    }else{
	    	Optional <LineaVenta> lineaVentaAModificar = obtenerLineaVentaPorLibro(u, l);

		    if(lineaVentaAModificar.isPresent()){
		    	LineaVenta lv = lineaVentaAModificar.get();
		    	lv.setCantidad(cantidad);
		    	lv.setSubtotal(lv.calcularSubtotalLineaVenta());
		    	
		        servicioVenta.edit(cesta);
		    }else{
		        agregarProducto(u, l);
		    }
	    }
	}
	
	//ELIMINAR LÍNEA DE VENTA DE LA CESTA.
	public void eliminarLineaDeVenta(Usuario u, Libro l){
		Venta cesta = obtenerCesta(u);

		Optional<LineaVenta> LineaVentaAEliminar = obtenerLineaVentaPorLibro(u, l);

		if(LineaVentaAEliminar.isPresent()){
			LineaVentaAEliminar.get().getLibro()
				.setStock(LineaVentaAEliminar.get().getLibro().getStock()+LineaVentaAEliminar.get().getCantidad());
			
			cesta.borrarLineaVenta(LineaVentaAEliminar.get());
			
			servicioVenta.edit(cesta);
		}
	}

	//SETEAR PRECIO FINAL.
	public void actualizarPrecioFinal (Usuario u) {
		Venta cesta = obtenerCesta(u);
		
		cesta.setPrecioFinal(calcularPrecioFinal(u));
		
		servicioVenta.edit(cesta);
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
