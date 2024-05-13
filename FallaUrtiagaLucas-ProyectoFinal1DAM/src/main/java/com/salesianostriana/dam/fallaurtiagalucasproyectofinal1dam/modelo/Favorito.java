package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Favorito {

	@EmbeddedId
	private FavoritoPK favoritoPK = new FavoritoPK();
	
	public Favorito(Usuario u, Libro l) {
		this.usuario = u;
		this.libro = l;
	}
	
	@ManyToOne
	@MapsId("idUsuario")
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@ManyToOne
	@MapsId("idLibro")
	@JoinColumn(name = "idLibro")
	private Libro libro;
	
	private boolean favorito;
	
	
	//Métodos "helper".
	
	public void agregarAUsuario(Usuario u) {
		u.getListadoFavoritos().add(this);
		this.usuario = u;
	}

	public void borrarDeUsuario(Usuario u) {
		u.getListadoFavoritos().remove(this);
		this.usuario = null;
	}
	
}
