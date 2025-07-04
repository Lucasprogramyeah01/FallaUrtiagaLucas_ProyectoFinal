package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

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
	
	private double precio;
	
	private int stock;
	
	private String autor;
	
	private String editorial;

	@Column(length = 1000)
	private String descripcion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaPublicacion;
	
	private int numPaginas;
	
	 @Enumerated(value = EnumType.STRING)
	private Cubierta cubierta;
	
	 @Enumerated(value = EnumType.STRING)
	private Publico publico;

	 
	//ASOCIACIÓN CON CATEGORÍA [ML - MC]
	 
	 	@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name = "tiene",
			joinColumns = @JoinColumn(name="libro_id"),
			inverseJoinColumns = @JoinColumn(name="categoria_id"))
	 	
	 	@Builder.Default
		private List<Categoria> listadoCategorias = new ArrayList<>();
	 	
	 	//Métodos "Helper".
	 	
	 	public void agregarCategoria(Categoria c) {
	 		this.listadoCategorias.add(c);
			c.getListadoLibros().add(this);
		}
	 	
	 	public void borrarCategoria(Categoria c) {
			c.getListadoLibros().remove(this);
			this.listadoCategorias.remove(c);
		}
	 	
	 	
	 //ASOCIACIÓN CON TIPO [ML - 1T]
	
	 	@ManyToOne
	    @JoinColumn(foreignKey = @ForeignKey(name="fk_libro_tipo"))
	    private Tipo tipo;
	 	
	 	//Métodos "helper".
	 	
	 	public void agregarATipo(Tipo tipo) {
			this.tipo = tipo;
			tipo.getListaDeLibros().add(this);
		}
		
		public void borrarDeTipo(Tipo tipo) {
			tipo.getListaDeLibros().remove(this);
			this.tipo = null;		
		}
	
		
	//ASOCIACIÓN CON LÍNEA VENTA [1L - MLV]
	 
		@ToString.Exclude
		@EqualsAndHashCode.Exclude
		@OneToMany(mappedBy="libro", fetch = FetchType.EAGER)
		@Builder.Default
		private List<LineaVenta> listaLineaVenta = new ArrayList<>();		
		
}
