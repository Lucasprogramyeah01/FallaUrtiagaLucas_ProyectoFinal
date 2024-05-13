package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LibroServicio;

@Controller
@RequestMapping("/admin")
public class LibroControlador {

	@Autowired
	private LibroServicio servicio;
	
	//MOSTRAR LISTA DE LIBROS.
	@GetMapping("/listaLibros")
	public String mostrarListaLibros(Model model) {
		model.addAttribute("listaLibros", servicio.findAll());
		
		return "/admin/pagAdminProductos";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
