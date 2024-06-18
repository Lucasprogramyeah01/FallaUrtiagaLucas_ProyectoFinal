package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.servicio.VentaServicio;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Venta {

	@Id @GeneratedValue
	private long idVenta;
	
	private double gastosEnvio;
	
	private double subtotal;
	
	private double precioFinal;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime fechaVenta;
	
	/*@Enumerated(value = EnumType.STRING)
	private Provincia provincia;
	
	private int codigoPostal;*/
	
	private boolean finalizada;
	
	
	//COMPOSICIÓN CON LÍNEA DE VENTA [MLV - 1V]
	
		@ToString.Exclude
		@EqualsAndHashCode.Exclude
		@Builder.Default
		@OneToMany(
				mappedBy="venta", 
				fetch = FetchType.EAGER,
				cascade = CascadeType.ALL,
				orphanRemoval = true)
		private List<LineaVenta> listadoLineaVenta = new ArrayList<>();
		
		//Métodos "helper".
		
		public void agregarLineaVenta(LineaVenta lineaVenta) {
			lineaVenta.setVenta(this);
			this.listadoLineaVenta.add(lineaVenta);
		}
				
		public void borrarLineaVenta(LineaVenta lineaVenta) {
			this.listadoLineaVenta.remove(lineaVenta);
			//lineaVenta.setVenta(null);
		}
		
		
	//ASOCIACIÓN CON USUARIO [1U - MV]
		
		@ManyToOne
		@JoinColumn(foreignKey = @ForeignKey(name="fk_venta_usuario"))
		private Usuario usuario;
			
		//Métodos "helper".
			
		public void agregarAUsuario(Usuario usuario) {
			this.usuario = usuario;
			usuario.getVenta().add(this);
		}
			
		public void borrarDeUsuario(Usuario usuario) {
			usuario.getVenta().remove(this);
			this.usuario = null;
		}
		

//--------------------------------------------------------------
		
		//CALCULAR DESCUENTO DE FAN DE SERIE
		public double calcularDescuentoDeFanDeSerie(double subtotalLV) {
			int numPorcentaje = 20;
			int cien = 100;
			
			subtotal = subtotalLV - ((subtotalLV*numPorcentaje)/cien);
			
			return subtotal;
		}
	
		//CALCULAR DESCUENTO ENVÍO GRATIS.
		public double calcularDescuentoEnvioGratuito() {
			if(subtotal > 30) {
				setGastosEnvio(0.00);
				
				return gastosEnvio;
			}else {
				setGastosEnvio(3.95);
				
				return gastosEnvio;
			}
		}
		
		
}
