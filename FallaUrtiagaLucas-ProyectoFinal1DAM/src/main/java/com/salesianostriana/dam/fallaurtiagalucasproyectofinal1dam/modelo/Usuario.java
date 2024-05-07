package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario {
	
	@Id @GeneratedValue
	private Long idUsuario;
	
	private String nombre;
	
	private String apellidos;
	
	private String correo;
	
	private String nombreUsuario;
	
	private String contrasenha;
	
	private String urlImagen;

	public Usuario(Long idUsuario, String nombre, String apellidos, String correo, String nombreUsuario,
			String contrasenha, String urlImagen) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.nombreUsuario = nombreUsuario;
		this.contrasenha = contrasenha;
		this.urlImagen = urlImagen;
	}
}
