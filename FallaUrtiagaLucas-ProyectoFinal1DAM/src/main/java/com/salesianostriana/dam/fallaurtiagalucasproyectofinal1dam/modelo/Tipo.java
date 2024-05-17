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
public class Tipo {

	@Id @GeneratedValue
	private Long idTipo;
	
	private String nombre;
	
	
	//ASOCIACIÓN CON LIBRO [ML - 1T]
	
		@ToString.Exclude
		@EqualsAndHashCode.Exclude
		@OneToMany(mappedBy="tipo", fetch = FetchType.EAGER)
		@Builder.Default
		private List<Libro> listaDeLibros = new ArrayList<>();

}
