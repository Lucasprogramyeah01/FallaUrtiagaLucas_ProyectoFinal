package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import java.util.ArrayList;
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

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.CategoriaServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LibroServicio;

@Controller
@RequestMapping("/admin")
public class LibroControlador {

	@Autowired
	private LibroServicio servicio;
	
	@Autowired
	private CategoriaServicio servicioCat;
	
	//MOSTRAR LISTA DE LIBROS.
	@GetMapping("/listaLibros")
	public String mostrarListaLibros(Model model) {
		model.addAttribute("listaLibros", servicio.findAll());	//CUIDAO
		
		return "/admin/pagAdminProductos";
	}
	
	//MOSTRAR FORMULARIO PARA AGREGAR LIBRO.
	@GetMapping("/agregarLibro")
	public String mostrarFormularioLibro(Model model, ArrayList<Long> listaIdsCat) {
			
 		Libro l = new Libro();
		model.addAttribute("libro", l);
		model.addAttribute("listaCategorias", servicioCat.findAll());
		model.addAttribute("listaIdsCat", listaIdsCat);//CUIDAO
				
		return "/admin/pagAdminAgregarProducto";
	}
	
	//AGREGAR LIBRO.
	@PostMapping("/agregarLibro/submit")
	public String procesarFormularioLibro(@ModelAttribute("libro") Libro l, Model model, @ModelAttribute("listaIdsCat") ArrayList<Long> listaIdsCat) {
		
		for (Long idCat : listaIdsCat) {
			
			l.getListadoCategorias().add(servicioCat.findById(idCat).get());
		}
		
		servicio.save(l);
		model.addAttribute("listaCategorias", servicioCat.findAll());	//CUIDAO
		
		return "redirect:/admin/listaLibros";
	}
	
	//MOSTRAR FORMULARIO PARA EDITAR LIBRO.
	@GetMapping("/editarLibro/{id}")
	public String mostrarFormularioEditarLibro(@PathVariable("id") long id, Model model) {
		model.addAttribute("listaCategorias", servicioCat.findAll());	//CUIDAO
			
		Optional<Libro> libro = servicio.findById(id);
			
		if (libro.isPresent()) {
			model.addAttribute("libro", libro.get());
			model.addAttribute("listaCategorias", servicioCat.findAll());	//CUIDAO
			model.addAttribute("libro", libro);		//CUIDAO
				
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
	public String borrarLibro(@PathVariable("id") long idLibro) {
		servicio.deleteById(idLibro);
			
		return "redirect:/admin/listaLibros";
	}
	
}
