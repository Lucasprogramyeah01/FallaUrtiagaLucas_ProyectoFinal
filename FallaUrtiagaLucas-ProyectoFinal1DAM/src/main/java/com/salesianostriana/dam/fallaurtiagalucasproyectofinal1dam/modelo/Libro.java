package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Libro {
	
	@Id @GeneratedValue
	private Long idLibro;
	
	private String titulo;
	
	private String imagenPortada;
	
	private String textoAltPortada;
	
	private String serie;
	
	@Enumerated(value = EnumType.STRING)
	private Tipo tipo;
	
	private double precio;
	
	private int stock;
	
	private String autor;
	
	private String editorial;
	
	private String descripcion;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime fechaPublicacion;
	
	private int numPaginas;
	
	 @Enumerated(value = EnumType.STRING)
	private Cubierta cubierta;
	
	 @Enumerated(value = EnumType.STRING)
	private Publico publico;

	 
	//ASOCIACIÓN CON CATEGORÍA [1L - MC]
	
		@ToString.Exclude
		@EqualsAndHashCode.Exclude
		@OneToMany(mappedBy="libro", fetch = FetchType.EAGER)
		@Builder.Default
		private List<Categoria> listadoCategorias = new ArrayList<>();
	
	
	//ASOCIACIÓN CON LÍNEA VENTA [1L - MLV]
	 
		@ToString.Exclude
		@EqualsAndHashCode.Exclude
		@OneToMany(mappedBy="libro", fetch = FetchType.EAGER)
		@Builder.Default
		private List<LineaVenta> listaLineaVenta = new ArrayList<>();		
		
}
