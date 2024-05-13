package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.UsuarioServicio;

@Controller
@RequestMapping("/admin")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	//Método que muestra el listado de usuarios.
	@GetMapping("/listaClientes")
	public String mostrarListaClientes(Model model) {
		model.addAttribute("listaClientes", servicio.findAll());
		return "/admin/pagAdminClientes";
	}
	

	//Método que atiende la petición de mostrar formulario para agregar a un nuevo usuario.
	@GetMapping("/agregarCliente")
	public String mostrarFormulario(Model model) {
		//model.addAttribute("cursos", cursoServicio.findAll());
		model.addAttribute("usuario", new Usuario());
		
		return "/admin/pagAdminAgregarCliente";
	}
	
	
	
	
}
