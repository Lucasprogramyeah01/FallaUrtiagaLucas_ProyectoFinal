package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.CategoriaServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LibroServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.TipoServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.UsuarioServicio;

@Controller
public class MainControlador {
	
	@Autowired
	private LibroServicio servicio;
	
	@Autowired
	private CategoriaServicio servicioCat;
	
	@Autowired
	private TipoServicio servicioTipo;
	
	@Autowired
	private UsuarioServicio servicioUsuario;
	
	
	//Mostrar página de inicio de administrador.
	@GetMapping("/admin/")
	public String mostrarInicioAdmin() {
		return "/admin/pagAdminInicio";
	}
	
	//Mostrar página de registro.
	@GetMapping("/registro")
	public String mostrarFormularioRegistro(Model model) {
		
		Usuario u = new Usuario();
		model.addAttribute("usuario", u);
		
		return "pagRegistro";
	}
	
	//Registrar usuario.
	@PostMapping("/registro/submit")
	public String procesarFormularioRegistro(@ModelAttribute("usuario") Usuario u) {
		
		List<Usuario> listaUsuarios = servicioUsuario.filtrarListaUsuarios();
		
		for(Usuario usuario : listaUsuarios) {	
			if(usuario.getUsername().equals(u.getUsername())) {
				return "redirect:/registro?error=true";
			}
		}
		servicioUsuario.saveUsuarioConContrasenhaCodificada(u);
		
		return "redirect:/login";
	}
	
	//EDITAR PERFIL DE USUARIO ----------------------------------------------------------------------------------------------
	
	//MOSTRAR FORMULARIO PARA EDITAR PERFIL.
	@GetMapping("/editarPerfil/{id}")
	public String mostrarFormularioEditarClientes(@PathVariable("id") Long id, Model model) {
			
		Optional<Usuario> usuario = servicioUsuario.findById(id);
			
		if (usuario.isPresent()) {
			model.addAttribute("usuario", usuario.get());
				
			return "pagEditarUsuario";
		}else {
				
			return "redirect:/";
		}
	}
	
	//EDITAR PERFIL.
	@PostMapping("/editarPerfil/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.save(u);
			
		return "redirect:/logout";
	}
	
	//MOSTRAR PÁGINAS DEL NAV Y EL FOOTER -----------------------------------------------------------------------------------
	
	@GetMapping("/")
	public String mostrarInicio(Model model) {
		
		model.addAttribute("listaLibros", servicio.filtrarLibrosPorOrdenAleatorioConLimite15());
		
		return "pagInicio";
	}
	
	@GetMapping("/seccionReemplazo")
	public String mostrarSeccionReemplazo() {
		return "pagSeccionReemplazo";
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
	
	//MOSTRAR PÁGINA DE FAVORITOS.
	@GetMapping("/favoritos")
	public String mostrarFavoritos(@AuthenticationPrincipal Usuario u, Model model) {

		model.addAttribute("listaLibros", servicioUsuario.filtrarlibrosFavoritos());
		
		return "pagFavoritos";
	}
	
	//AGREGAR A FAVORITOS (Al clickar en el botón de corazón si el libro no está marcado como favorito).
	@GetMapping("/agregarAFavoritos/{id}")
	public String agregarAFavoritos(@PathVariable("id") Long idLibro, @AuthenticationPrincipal Usuario u, 
			Model model, ArrayList<Libro> listaLibros) {
		
		Optional<Libro> libroFavorito = servicio.findById(idLibro);
		
		for(Libro libro : listaLibros) {
			if(libroFavorito.isPresent() && libro.getIdLibro() != libroFavorito.get().getIdLibro()) {
				u.getListadoFavoritos().add(libroFavorito.get());
			}
		}

		//if(!u.getListadoFavoritos().contains(libroFavorito)) {
		
		servicioUsuario.edit(u);
		
		return "redirect:/favoritos";	//METER SCRIPT PARA QUE SE MANTENGA LA PÁGINA SIN REFRESCAR.
	}
	
	//PROCESAR "AGREGAR A FAVORITOS".
	/*@PostMapping("/agregarAFavoritos/submit")
	public String procesarAgregarAFavoritos(@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.save(u);
				
		return "redirect:/favoritos";
	}*/
	
	//BORRAR DE FAVORITOS (Al clickar en el botón de corazón si el libro está marcado como favorito).
	@PostMapping("/borrarDeFavoritos/{id}/submit")
	public String borrarDeFavoritos(@PathVariable("id") Long idLibro, @AuthenticationPrincipal Usuario u,
			Model model) {
		
		Optional<Libro> libroFavorito = servicio.findById(idLibro);
		
		if(libroFavorito.isPresent()) {
			u.getListadoFavoritos().remove(libroFavorito.get());
		}
		
		servicioUsuario.save(u);
		
		return "redirect:/favoritos";	//METER SCRIPT PARA QUE SE MANTENGA LA PÁGINA SIN REFRESCAR.
	}
	
	//PROCESAR "AGREGAR A FAVORITOS".
	/*@PostMapping("/borrarDeFavoritos/submit")
	public String procesarBorrarDeFavoritos(@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.save(u);
					
		return "redirect:/favoritos";
	}*/
	
	//AQUELLO QUE TIENE QUE VER CON EL CATÁLOGO EMPIEZA AQUÍ ----------------------------------------------------------------

	@GetMapping("/catalogo")
	public String mostrarCatalogo(/*@RequestParam(name="idTipo", required=false)*/ Long idTipo, Long idCategoria, 
			@Param("palabraClave") String palabraClave, Model model) {
		
		model.addAttribute("listaCategorias", servicioCat.findAll());
		model.addAttribute("listaTipos", servicioTipo.findAll());

		model.addAttribute("palabraClave", palabraClave);
		
		if(idTipo == null && idCategoria == null) {
			
			if(palabraClave == null) {
				model.addAttribute("listaLibros", servicio.filtrarLibrosPorOrdenAleatorio());
			}else {
				model.addAttribute("listaLibros", servicio.filtrarLibrosPorPalabraClave(palabraClave));
			}
			
		}else {
			model.addAttribute("listaLibros", servicio.findAll());
		}
		
		return "pagBusqueda";
	}
	
	//MOSTRAR INFORMACIÓN DE LOS PRODUCTOS.
	@GetMapping("/infoLibro/{id}")
	public String mostrarInformacionProducto(@PathVariable("id") Long idLibro, Model model) {
		
		Optional<Libro> libro = servicio.findById(idLibro);
		
		if(libro.isPresent()) {
			model.addAttribute("libro", libro.get());
			model.addAttribute("listaCategorias", servicioCat.findAll());
			model.addAttribute("listaTipos", servicioTipo.findAll());
			
			return "pagInfoProd";
		
		}else {
			
			return "redirect:/catalogo";
		}
	}
	
	//FILTRAR LIBROS POR SERIE.
	@GetMapping("/serie/{nombre}")
	public String mostrarSerieDeLibro(@PathVariable("nombre") String nombre, Model model) {
		
		model.addAttribute("listaLibros", servicio.filtrarLibrosPorSerie(nombre));
		
		return "pagSerie";
	}
	
	//FILTRAR LIBROS POR TIPO.
	@GetMapping("/catalogo/tipo/{id}")
	public String mostrarCatalogoFiltradoPorIdTipo(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("listaLibros", servicio.filtrarLibroPorTipo(id));
		
		model.addAttribute("listaCategorias", servicioCat.findAll());
		model.addAttribute("listaTipos", servicioTipo.findAll());
		
		return "pagBusqueda";
	}
	
	//FILTRAR LIBROS POR CATEGORÍA.
	@GetMapping("/catalogo/categoria/{id}")
	public String mostrarCatalogoFiltradoPorIdCategoria(@PathVariable("id") Long id, Model model) {
			
		model.addAttribute("listaLibros", servicio.filtrarLibroPorCategoria(id));
			
		model.addAttribute("listaCategorias", servicioCat.findAll());
		model.addAttribute("listaTipos", servicioTipo.findAll());
			
		return "pagBusqueda";
	}
	
	//FILTRAR LIBROS POR FECHA DE PUBLICACIÓN.
	@GetMapping("/proximamente")
	public String mostrarLibrosPagInicioFiltradosPorFechaPublicacion(Model model) {
			
		model.addAttribute("listaLibros", servicio.filtrarLibrosPorFechaPublicacion());

		return "pagInicio";
	}
	
	//FILTRO DE NOVEDADES.
	@GetMapping("/novedades")
	public String mostrarLibrosPagInicioNuevos(Model model) {
				
		model.addAttribute("listaLibros", servicio.librosNuevos());

		return "pagInicio";
	}
	
}
