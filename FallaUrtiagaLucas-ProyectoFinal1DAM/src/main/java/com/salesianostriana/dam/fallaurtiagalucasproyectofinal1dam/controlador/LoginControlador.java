package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginControlador {
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@PostMapping("/logout")
	public String cerrarSesion() {
		return "redirect:/";
	}
	
}
