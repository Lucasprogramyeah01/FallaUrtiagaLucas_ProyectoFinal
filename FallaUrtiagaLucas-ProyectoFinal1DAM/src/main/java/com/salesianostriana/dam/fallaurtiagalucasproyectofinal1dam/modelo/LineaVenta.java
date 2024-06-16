package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@IdClass(LineaVentaPK.class)
public class LineaVenta {
	
	@Id @GeneratedValue
	private Long idLineaVenta;
	
	private int cantidad;
	
	
	//COMPOSICIÓN CON VENTA [MLV - 1V]
	
		@Id
		@ManyToOne
		private Venta venta;
	
		
	//ASOCIACIÓN CON LIBRO [1L - MLV]
	
		@ManyToOne
		@JoinColumn(foreignKey = @ForeignKey(name="fk_lineaVenta_libro"))
		private Libro libro;
		
		//Métodos "helper".
		
		public void agregarALibro(Libro libro) {
			this.libro = libro;
			libro.getListaLineaVenta().add(this);
		}
						
		public void borrarDeLibro(Libro libro) {
			libro.getListaLineaVenta().remove(this);
			this.libro = null;
		}
		
		
//--------------------------------------------------------------
		
	//CALCULAR SUBTOTAL DE UNA LÍNEA DE VENTA.	
	public double calcularSubtotalLineaVenta() {
		return libro.getPrecio()*cantidad;
	}

}
