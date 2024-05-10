package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.UsuarioServicio;

@Controller
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/admin/clientes")
	public String mostrarInicio() {
		return "admin/pagAdminClientes";
	}
	
	
	
}
