package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlador {

	@GetMapping("/")
	public String mostrarInicio() {
		return "pagInicio";
	}
	
	@GetMapping("/quienesSomos")
	public String mostrarQuienesSomos() {
		return "pagQuienesSomos";
	}
	
	@GetMapping("/condicionesDeUso")
	public String mostrarCondicionesDeUso() {
		return "pagCondicionesDeUso";
	}
	
	@GetMapping("/politicaDePrivacidad")
	public String mostrarPoliticaDePrivacidad() {
		return "pagPoliticaDePrivacidad";
	}
	
	@GetMapping("/favoritos")
	public String mostrarFavoritos() {
		return "pagFavoritos";
	}
	
}
