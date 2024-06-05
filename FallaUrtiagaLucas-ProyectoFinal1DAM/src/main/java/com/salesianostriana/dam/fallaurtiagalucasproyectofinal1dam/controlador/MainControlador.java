package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.CategoriaServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.LibroServicio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.TipoServicio;

@Controller
public class MainControlador {

	//public static final int NumProductosAleatorios = 4;
	
	@Autowired
	private LibroServicio servicio;
	
	@Autowired
	private CategoriaServicio servicioCat;
	
	@Autowired
	private TipoServicio servicioTipo;
	
	
	//MOSTRAR PÁGINAS DEL NAV -----------------------------------------------------------------------------------------------
	
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
	
	
	//AQUELLO QUE TIENE QUE VER CON EL CATÁLOGO EMPIEZA AQUÍ ----------------------------------------------------------------
	
	@GetMapping("/catalogo")
	public String mostrarCatalogo(@RequestParam(name="idTipo", required=false) Long idTipo,Long idCategoria, Model model) {
		
		model.addAttribute("listaCategorias", servicioCat.findAll());
		model.addAttribute("listaTipos", servicioTipo.findAll());
		
		/*List<Libro> listaLibros;
		
		if(idTipo == null && idCategoria == null) {
			//listaLibros = servicio.generarLibrosAleatorios(NumProductosAleatorios);
		
			model.addAttribute("listaLibros", servicio.generarLibrosAleatorios(16));
		}*/
		
		model.addAttribute("listaLibros", servicio.findAll());
		
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
	
	
}
