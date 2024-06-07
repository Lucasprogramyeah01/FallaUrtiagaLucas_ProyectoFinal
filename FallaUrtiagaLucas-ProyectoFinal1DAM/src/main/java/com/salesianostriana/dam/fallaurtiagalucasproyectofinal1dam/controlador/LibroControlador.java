package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Cubierta;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Publico;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.CategoriaServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LibroServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.TipoServicio;

@Controller
@RequestMapping("/admin")
public class LibroControlador {

	@Autowired
	private LibroServicio servicio;
	
	@Autowired
	private CategoriaServicio servicioCat;
	
	@Autowired
	private TipoServicio servicioTipo;
	
	//MOSTRAR LISTA DE LIBROS.
	@GetMapping("/listaLibros")
	public String mostrarListaLibros(Model model) {
		model.addAttribute("listaLibros", servicio.findAll());	//CUIDAO
		
		return "/admin/pagAdminProductos";
	}
	
	//MOSTRAR FORMULARIO PARA AGREGAR LIBRO.
	@GetMapping("/agregarLibro")
	public String mostrarFormularioLibro(Model model, ArrayList<Long> listaIdsCat) {
		
		if(servicio.cantidadDeTipos()==0 || servicio.cantidadDeCategorias()==0) {
			return "redirect:/admin/listaLibros?error=true";
		}else {
	 		Libro l = new Libro();
			model.addAttribute("libro", l);
			
			model.addAttribute("listaCategorias", servicioCat.findAll());
			model.addAttribute("listaIdsCat", listaIdsCat);		//CUIDAO
			
			model.addAttribute("listaTipos", servicioTipo.findAll());
			
			model.addAttribute("listaCubiertas", Cubierta.values());	//Array de cubiertas (Para el enum).
			model.addAttribute("listaPublicos", Publico.values());		//Array de "públicos" (Para el enum).
		}
				
		return "/admin/pagAdminAgregarProducto";
	}
	
	//AGREGAR LIBRO.
	@PostMapping("/agregarLibro/submit")
	public String procesarFormularioLibro(@ModelAttribute("libro") Libro l, Model model, 
			@ModelAttribute("listaIdsCat") ArrayList<Long> listaIdsCat) {
		
		for (Long idCat : listaIdsCat) {
			l.getListadoCategorias().add(servicioCat.findById(idCat).get());
		}
		
		servicio.save(l);
		model.addAttribute("listaCategorias", servicioCat.findAll());	//CUIDAO

		return "redirect:/admin/listaLibros";
	}
	
	//MOSTRAR FORMULARIO PARA EDITAR LIBRO.
	@GetMapping("/editarLibro/{id}")
	public String mostrarFormularioEditarLibro(@PathVariable("id") Long idLibro, Model model) {
		//model.addAttribute("listaCategorias", servicioCat.findAll());	//CUIDAO
			
		Optional<Libro> libro = servicio.findById(idLibro);
			
		if (libro.isPresent()) {
			model.addAttribute("libro", libro.get());
			model.addAttribute("listaCategorias", servicioCat.findAll());	//CUIDAO
			model.addAttribute("listaTipos", servicioTipo.findAll());
			model.addAttribute("listaCubiertas", Cubierta.values());
			model.addAttribute("listaPublicos", Publico.values());
			
			/*model.addAttribute("libro", libro);*/		//CUIDAO
			
			return "/admin/pagAdminAgregarProducto";
		}else {

			return "redirect:/admin/listaLibros";
		}
	}
	
	//EDITAR LIBRO.
	@PostMapping("/editarLibro/submit")
	public String procesarFormularioEditarLibro(@ModelAttribute("libro") Libro l) {
		servicio.save(l);
		
		return "redirect:/admin/listaLibros";
	}
		
	//BORRAR LIBRO.
	@GetMapping("/borrarLibro/{id}")
	public String borrarLibro(@PathVariable("id") Long idLibro) {
		servicio.deleteById(idLibro);
			
		return "redirect:/admin/listaLibros";
	}
	
	
}
