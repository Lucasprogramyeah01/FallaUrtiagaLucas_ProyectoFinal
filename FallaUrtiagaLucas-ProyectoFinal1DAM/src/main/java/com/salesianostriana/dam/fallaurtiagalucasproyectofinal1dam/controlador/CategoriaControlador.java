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
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.TipoServicio;

@Controller
@RequestMapping("/admin")
public class CategoriaControlador {

	@Autowired
	private CategoriaServicio servicio;
	
	@Autowired
	private TipoServicio tipoServicio;
	
	//MOSTRAR LISTA DE CATEGORÍAS (Y TIPOS).
	@GetMapping("/listaCategorias")
	public String mostrarListaCategorias(Model model) {
		model.addAttribute("listaCategorias", servicio.findAll());
		
		model.addAttribute("listaTipos", tipoServicio.findAll());
		
		/*He añadido el servicio "TipoServicio" al controlador de Categoría porque me hace falta tener una lista
		 *(o sea, tabla) de Tipos en la misma página en la que tengo una lista (o sea, tabla) de Categorías. La 
		 *razón de porqué meto el model "listaTipos" en un controlador que nada tiene que ver con el Tipo de libro
		 *es por el hecho de que si creo un método para mostrar la lista de tipos en el TipoControlador, tendría 
		 *que escribirle la misma ruta de acceso que la de este otro método, lo cual no es posible. Así que para 
		 *remediarlo, he aquí mi gran apaño.*/
			
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
