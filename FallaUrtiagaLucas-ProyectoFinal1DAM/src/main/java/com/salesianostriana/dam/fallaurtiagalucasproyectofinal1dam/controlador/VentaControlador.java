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

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.LineaVenta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Venta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.CestaServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.VentaServicio;

@Controller
public class VentaControlador {

	@Autowired
	private VentaServicio servicioVenta;
	
	@Autowired
	private CestaServicio servicioCesta;
	
	
	//MOSTRAR PÁGINA CESTA.
	@GetMapping("/cesta")
	public String mostrarCesta(@AuthenticationPrincipal Usuario u, Model model) {

		//Falta código aquí.
		
		return "pagCesta";
	}
    
    	
	
	
}
