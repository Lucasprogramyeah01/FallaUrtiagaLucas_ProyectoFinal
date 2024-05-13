package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Categoria {

	@Id @GeneratedValue
	private Long idCategoria;
	
	private String nombre;
	
	
	//ASOCIACIÓN CON LIBRO [1L - MC]
	
		@ManyToOne
		@JoinColumn(foreignKey = @ForeignKey(name="fk_categoria_libro"))
		private Libro libro;
		
		//Métodos "helper".
		
		public void agregarALibro(Libro libro) {
			this.libro = libro;
			libro.getListadoCategorias().add(this);
		}
			
		public void borrarDeLibro(Libro libro) {
			libro.getListadoCategorias().remove(this);
			this.libro = null;
		}

}
