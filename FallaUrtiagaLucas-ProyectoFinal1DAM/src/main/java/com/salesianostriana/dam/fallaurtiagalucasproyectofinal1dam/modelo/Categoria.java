package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Categoria {

	@Id @GeneratedValue
	private Long idCategoria;
	
	private String nombre;
	
	
	//ASOCIACIÓN CON LIBRO [ML - MC]

		@ManyToMany(mappedBy="listadoCategorias", fetch = FetchType.EAGER)
		@Builder.Default
		@ToString.Exclude
		@EqualsAndHashCode.Exclude
		private List<Libro> listadoLibros = new ArrayList<>();
	
}
