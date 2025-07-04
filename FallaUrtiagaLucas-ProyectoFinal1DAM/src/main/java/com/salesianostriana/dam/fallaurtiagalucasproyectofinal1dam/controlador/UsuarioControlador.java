package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

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
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LibroServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.UsuarioServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.VentaServicio;

@Controller
@RequestMapping("/admin")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@Autowired
	private LibroServicio libroServicio;
	
	@Autowired
	private VentaServicio servicioVenta;
	
	//MOSTRAR LISTA DE USUARIOS.
	@GetMapping("/listaClientes")
	public String mostrarListaClientes(Model model) {
		model.addAttribute("listaClientes", servicio.findAll());
		
		return "/admin/pagAdminClientes";
	}
	
	//MOSTRAR FORMULARIO PARA AGREGAR USUARIO.
	@GetMapping("/agregarCliente")
	public String mostrarFormularioRegistroClientes(Model model) {
		
		Usuario u = new Usuario();
		model.addAttribute("usuario", u);
		
		return "/admin/pagAdminAgregarCliente";
	}
	
	//AGREGAR USUARIO.
	@PostMapping("/agregarCliente/submit")
	public String procesarFormularioRegistroClientes(@ModelAttribute("usuario") Usuario u) {
		
		List<Usuario> listaUsuarios = servicio.filtrarListaUsuarios();
		
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getUsername().equals(u.getUsername())) {
				return "redirect:/admin/agregarCliente?error=true";
			}
		}
		servicio.saveUsuarioConContrasenhaCodificada(u);
		
		return "redirect:/admin/listaClientes";
	}
	
	//BORRAR USUARIO.
	@GetMapping("/borrarCliente/{id}")
	public String borrarCliente(@PathVariable("id") long idUsuario) {
		
		
		servicio.deleteById(idUsuario);
		
		return "redirect:/admin/listaClientes";
	}
	
	
	//BORRAR USUARIO.
	@GetMapping("/ventas/{id}")
	public String mostrarVentasCliente(@PathVariable("id") Long idUsuario, Model model) {
		model.addAttribute("listaVentas", servicioVenta.filtrarVentasPorUsuario(idUsuario));
		
		return "/admin/pagAdminVentasCliente";
	}
	
	
	
	
	
	
	
	//MARCAR LIBRO COMO FAVORITO. [NO FUNCIONA CORRECTAMENTE] ---------------------------------------------------------
	@GetMapping("/agregarAFavoritos")
	public String marcarLibroComoFavorito(@ModelAttribute("usuario") Usuario u, 
			@ModelAttribute("libro") Libro l) {
		
		u.getListadoFavoritos().add(l);
		
		return "pagFavoritos";
	}
	
}
