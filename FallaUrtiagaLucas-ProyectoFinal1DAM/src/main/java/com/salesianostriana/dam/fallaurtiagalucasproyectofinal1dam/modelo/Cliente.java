package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("Cliente")
public class Cliente extends Usuario{
	
	private int numPuntos;
	
	public Cliente(Long idUsuario, String nombre, String apellidos, String correo, String nombreUsuario,
			String contrasenha, String urlImagen, int numPuntos) {
		super(idUsuario, nombre, apellidos, correo, nombreUsuario, contrasenha, urlImagen);
		this.numPuntos = numPuntos;
	}

}
