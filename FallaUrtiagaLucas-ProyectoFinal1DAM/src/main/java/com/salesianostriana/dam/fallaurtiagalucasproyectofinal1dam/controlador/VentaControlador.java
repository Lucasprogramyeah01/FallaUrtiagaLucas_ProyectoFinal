package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.LineaVenta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Venta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.CestaServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LibroServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LineaVentaServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.VentaServicio;

@Controller
public class VentaControlador {

	@Autowired
	private VentaServicio servicioVenta;
	
	@Autowired
	private CestaServicio servicioCesta;
	
	@Autowired
	private LibroServicio servicioLibro;
	
	@Autowired
	private LineaVentaServicio servicioLV;
	
	//MOSTRAR PÁGINA CESTA.
	@GetMapping("/cesta")
	public String mostrarCesta(@AuthenticationPrincipal Usuario u, Libro l, Model model) {
		
		model.addAttribute("venta", servicioCesta.obtenerCesta(u));
		model.addAttribute("listaLineasVenta", servicioCesta.obtenerCesta(u).getListadoLineaVenta());
		
		servicioCesta.calcularPrecioFinal(u);
		
		servicioCesta.actualizarPrecioFinal(u);
		
		return "pagCesta";
	}
	
	//MOSTRAR PÁGINA CESTA.
	@GetMapping("/cesta/submit")
	public String procesarCesta(@AuthenticationPrincipal Usuario u, Libro l, @ModelAttribute("venta") Venta v, Model model) {
		int puntosASumar = 50;
		
		servicioCesta.finalizarCompra(u);
		
		u.setNumPuntosHon(u.getNumPuntosHon()+puntosASumar);
		
		return "pagCompraRealizada";
	}
	
	//AGREGAR UN PRODUCTO A LA CESTA.
	@GetMapping("/agregarACesta/{id}")
	public String agregarProductoACesta(@PathVariable("id") Long idLibro, @AuthenticationPrincipal Usuario u, 
			Model model) {
		
		Optional<Libro> productoAAgregar = servicioLibro.findById(idLibro);
		
		if(productoAAgregar.isPresent()) {
			servicioCesta.agregarProducto(u, productoAAgregar.get());
			
			return "redirect:/cesta";
		}else {
			return "redirect:/";
		}
	}
	
	//AGREGAR UN PRODUCTO A LA CESTA.
	@GetMapping("/borrarDeCesta/{id}")
	public String borrarProductoDeCesta(@PathVariable("id") Long idLibro, @AuthenticationPrincipal Usuario u, 
			Model model) {
		
		Optional<Libro> productoABorrar = servicioLibro.findById(idLibro);
		
		Optional <LineaVenta> lv = servicioCesta.obtenerLineaVentaPorLibro(u, productoABorrar.get());
		
		if(productoABorrar.isPresent()) {
			servicioCesta.eliminarProducto(u, productoABorrar.get(), lv.get().getCantidad());
			
			return "redirect:/cesta";
		}else {
			return "redirect:/";
		}
	}
	
	//MODIFICAR LA CANTIDAD DE UN PRODUCTO DE LA CESTA.
	@PostMapping("/modificarCantidadCesta/{id}/{cant}")
	public String modificarCantidadProducto(@PathVariable("id") Long idLibro, @PathVariable("cant") int cantidad, 
			@AuthenticationPrincipal Usuario u, Model model) {
		
		Optional<Libro> productoAModificar = servicioLibro.findById(idLibro);
		
		if(productoAModificar.isPresent()) {
			servicioCesta.modificarCantidad(u, productoAModificar.get(), cantidad);
			
			return "redirect:/cesta";
		}else {
			return "redirect:/";
		}
	}
    	
	//ELIMINAR LÍNEA DE VENTA DE LA CESTA.
	@GetMapping("/borrarLineaVentaDeCesta/{id}")
	public String borrarLineaDeVentaDeCesta(@PathVariable("id") Long idLibro, @AuthenticationPrincipal Usuario u, 
			Model model) {
		
		Optional<Libro> productoABorrar = servicioLibro.findById(idLibro);
		
		if(productoABorrar.isPresent()) {
			servicioCesta.eliminarLineaDeVenta(u, productoABorrar.get());
			
			return "redirect:/cesta";
		}else {
			return "redirect:/";	
		}
	}
	
}
