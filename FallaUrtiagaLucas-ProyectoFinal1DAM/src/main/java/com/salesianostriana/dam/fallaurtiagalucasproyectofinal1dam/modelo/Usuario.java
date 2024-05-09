package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Usuario {
	
	@Id @GeneratedValue
	private Long idUsuario;
	
	private String nombre;
	
	private String apellidos;
	
	private String correo;
	
	private String nombreUsuario;
	
	private String contrasenha;
	
	private String imagen;

	private int numPuntos;
	
	private boolean admin;
}
