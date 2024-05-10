package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.UsuarioServicio;

@Controller
@RequestMapping("/admin")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/clientes")
	public String mostrarInicio() {
		return "admin/pagAdminClientes";
	}
	
	
	
}
