package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Categoria;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.CategoriaServicio;

@Controller
@RequestMapping("/admin")
public class CategoriaControlador {

	@Autowired
	private CategoriaServicio servicio;
	
	//MOSTRAR LISTA DE CATEGORÍAS.
	@GetMapping("/listaCategorias")
	public String mostrarListaCategorias(Model model) {
		model.addAttribute("listaCategorias", servicio.findAll());
			
		return "/admin/pagAdminCategoria";
	}
	
	//MOSTRAR FORMULARIO PARA AGREGAR CATEGORIA.
	@GetMapping("/agregarCategoria")
	public String mostrarFormularioCategorias(Model model) {
		
		Categoria c = new Categoria();
		model.addAttribute("categoria", c);
			
		return "/admin/pagAdminAgregarCategoria";
	}
		
	//AGREGAR CATEGORÍA.
	@PostMapping("/agregarCategoria/submit")
	public String procesarFormularioCategorias(@ModelAttribute("categoria") Categoria c, Model model) {
		servicio.save(c);
			
		return "redirect:/admin/listaCategorias";
	}
	
	//MOSTRAR FORMULARIO PARA EDITAR UNA CATEGORÍA.
	@GetMapping("/editarCategoria/{id}")
	public String mostrarFormularioEditarCategorias(@PathVariable("id") long id, Model model) {
			
		Optional<Categoria> categoria = servicio.findById(id);
			
		if (categoria.isPresent()) {
			model.addAttribute("categoria", categoria.get());
				
			return "/admin/pagAdminAgregarCategoria";
		}else {
				
			return "redirect:/admin/listaCategorias";
		}
	}
	
	//EDITAR CATEGORÍA.
	@PostMapping("/editarCategoria/submit")
	public String procesarFormularioEditarCategorias(@ModelAttribute("categoria") Categoria c) {
		servicio.save(c);
			
		return "redirect:/admin/listaCategorias";
	}
		
	//BORRAR CATEGORÍA.
	@GetMapping("/borrarCategoria/{id}")
	public String borrarCategoria(@PathVariable("id") long idCategoria) {
		servicio.deleteById(idCategoria);
			
		return "redirect:/admin/listaCategorias";
	}
	
	
}
