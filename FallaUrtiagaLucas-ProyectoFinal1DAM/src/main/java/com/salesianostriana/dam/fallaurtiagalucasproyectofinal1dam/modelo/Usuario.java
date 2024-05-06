package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	
	@Id @GeneratedValue
	private Long idUsuario;
	
	private String nombre;
	
	private String apellidos;
	
	private String correo;
	
	private String nombreUsuario;
	
	private String contrasenha;
	
	private String urlImagen;
}
