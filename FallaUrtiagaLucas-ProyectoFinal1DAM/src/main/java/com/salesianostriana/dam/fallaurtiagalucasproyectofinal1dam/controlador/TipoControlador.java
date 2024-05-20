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

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Tipo;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.TipoServicio;

@Controller
@RequestMapping("/admin")
public class TipoControlador {

	@Autowired
	private TipoServicio servicio;
	
	//"MOSTRAR LISTA DE TIPOS" se encuentra en "CategoriaControlador", allí está explicado el porqué.
	
	//MOSTRAR FORMULARIO PARA AGREGAR TIPO.
	@GetMapping("/agregarTipo")
	public String mostrarFormularioTipos(Model model) {
			
		Tipo t = new Tipo();
		model.addAttribute("tipo", t);
				
		return "/admin/pagAdminAgregarTipo";
	}
	
	//AGREGAR TIPO.
	@PostMapping("/agregarTipo/submit")
	public String procesarFormularioTipos(@ModelAttribute("tipo") Tipo t, Model model) {
		servicio.save(t);
				
		return "redirect:/admin/listaCategorias";
	}
	
	//MOSTRAR FORMULARIO PARA EDITAR UN TIPO.
	@GetMapping("/editarTipo/{id}")
	public String mostrarFormularioEditarTipos(@PathVariable("id") long id, Model model) {
				
		Optional<Tipo> tipo = servicio.findById(id);
				
		if (tipo.isPresent()) {
				model.addAttribute("tipo", tipo.get());
					
			return "/admin/pagAdminAgregarTipo";
		}else {
					
			return "redirect:/admin/listaCategorias";
		}
	}
	
	//EDITAR TIPO.
	@PostMapping("/editarTipo/submit")
	public String procesarFormularioEditarTipos(@ModelAttribute("tipo") Tipo t) {
		servicio.save(t);
				
		return "redirect:/admin/listaCategorias";
	}
	
	//BORRAR CATEGORÍA.
	@GetMapping("/borrarTipo/{id}")
	public String borrarTipo(@PathVariable("id") long idTipo) {
		servicio.deleteById(idTipo);
				
		return "redirect:/admin/listaCategorias";
	}

}
