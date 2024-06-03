package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.CategoriaServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LibroServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.TipoServicio;

@Controller
public class MainControlador {

	@Autowired
	private LibroServicio servicio;
	
	@Autowired
	private CategoriaServicio servicioCat;
	
	@Autowired
	private TipoServicio servicioTipo;
	
	
	//MOSTRAR PÁGINAS DEL NAV -------------------------------------------------------------------------------------------------
	
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
	
	
	//AQUELLO QUE TIENE QUE VER CON EL CATÁLOGO EMPIEZA AQUÍ ------------------------------------------------------------------
	
	@GetMapping("/catalogo")
	public String mostrarCatalogo(Model model) {
		
		model.addAttribute("listaLibros", servicio.findAll());
		
		model.addAttribute("listaCategorias", servicioCat.findAll());
		
		model.addAttribute("listaTipos", servicioTipo.findAll());
		
		return "pagBusqueda";
	}
	
	@GetMapping("/infoLibro/{id}")
	public String mostrarInformacionProducto(@PathVariable("id") Long idLibro, Model model) {
		
		Optional<Libro> libro = servicio.findById(idLibro);
		
		if(libro.isPresent()) {
			model.addAttribute("listaLibros", servicio.findAll());
			
			model.addAttribute("listaCategorias", servicioCat.findAll());
			
			model.addAttribute("listaTipos", servicioTipo.findAll());
			
			return "pagInfoProd";
		
		}else {
			
			return "redirect:/catalogo";
		}
	}
	
}
