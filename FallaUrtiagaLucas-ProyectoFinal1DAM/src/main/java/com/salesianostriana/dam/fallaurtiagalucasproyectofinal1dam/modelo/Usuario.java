package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	
	//ASOCIACIÓN CON VENTA [1U - MV]
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Venta> venta = new ArrayList<>();
	
}
