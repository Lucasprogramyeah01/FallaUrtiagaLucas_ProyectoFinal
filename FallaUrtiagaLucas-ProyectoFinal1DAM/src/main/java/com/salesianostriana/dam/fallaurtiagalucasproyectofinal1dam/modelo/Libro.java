package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Libro {
	
	@Id
	private Long isbn;
	
	private String titulo;
	
	private String urlImagen;
	
	private String serie;
	
	@Enumerated(value = EnumType.STRING)
	private Tipo tipo;
	
	@Enumerated(value = EnumType.STRING)
	private Genero genero;
	
	private double precio;
	
	private String autor;
	
	private String editorial;
	
	private String descripcion;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime fechaPublicacion;
	
	private int numPaginas;
	
	 @Enumerated(value = EnumType.STRING)
	private Cubierta cubierta;
	
	 @Enumerated(value = EnumType.STRING)
	private Publico publico;
	
}
