package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Libro;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo.Usuario;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.repositorio.UsuarioRepositorio;
import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.base.ServicioBaseImpl;

@Service
public class UsuarioServicio extends ServicioBaseImpl<Usuario, Long, UsuarioRepositorio>{

	@Autowired
	private UsuarioRepositorio repoUsuario;
	
	@Autowired
    private PasswordEncoder encoder;

	
	//PASSWORD ENCODER.
	public void saveUsuarioConContrasenhaCodificada(Usuario u) {
		u.setPassword(encoder.encode(u.getPassword()));
		repoUsuario.save(u);
    }
	
	
	//Obtener la lista de Favoritos de un usuario.
	public List<Libro> filtrarlibrosFavoritos () {
		List<Libro> librosFavoritosFiltrados = repoUsuario.findLibroByFavorito();
		
		return librosFavoritosFiltrados;
	}
	
	
	//Obtener una lista de todos los usuarios.
	public List<Usuario> filtrarListaUsuarios () {
		List<Usuario> listaUsuarios = repoUsuario.findListaUsuarios();
			
		return listaUsuarios;
	}
	
	
	//Obtener una lista de todos los usuarios menos aquel que tenga el ID pasado por parámetro.
	public List<Usuario> filtrarListaUsuariosExcluyendoAquelCuyoIdSeaIgualAlPasPar (Long idUsuario) {
		List<Usuario> listaUsuarios = repoUsuario.findListaUsuariosByExcludingId(idUsuario);
				
		return listaUsuarios;
	}
	
	
	//Obtener una lista de todos los usuarios menos aquel que tenga el ID pasado por parámetro.
	/*public List<Usuario> filtrarListaUsuariosDeUnUsuarioPorId (Long idUsuario) {
		List<Usuario> listaUsuarios = repoUsuario.findListaUsuariosById(idUsuario);
					
		return listaUsuarios;
	}*/
	
}
