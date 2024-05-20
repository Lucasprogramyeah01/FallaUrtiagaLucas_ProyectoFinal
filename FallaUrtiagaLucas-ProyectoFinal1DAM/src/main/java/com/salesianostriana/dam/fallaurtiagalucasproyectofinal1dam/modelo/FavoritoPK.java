package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Embeddable
public class FavoritoPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		private Long idUsuario;
		
		private Long idLibro;

}
