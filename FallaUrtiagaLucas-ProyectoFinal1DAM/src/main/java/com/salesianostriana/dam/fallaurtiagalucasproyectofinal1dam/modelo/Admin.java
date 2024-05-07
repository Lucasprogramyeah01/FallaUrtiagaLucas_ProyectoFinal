package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Usuario{

	private Long idEmpleado;
	
	public Admin(Long idUsuario, String nombre, String apellidos, String correo, String nombreUsuario,
			String contrasenha, String urlImagen, Long idEmpleado) {
		super(idUsuario, nombre, apellidos, correo, nombreUsuario, contrasenha, urlImagen);
		this.idEmpleado = idEmpleado;
	}
	
}
