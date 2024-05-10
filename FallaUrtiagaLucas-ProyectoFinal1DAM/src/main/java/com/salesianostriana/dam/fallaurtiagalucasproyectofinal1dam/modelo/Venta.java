package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Venta {

	@Id @GeneratedValue
	private long idVenta;
	
	private double gastosEnvio;
	
	private double subtotal;
	
	private double precioFinal;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime fechaVenta;
	
	@Enumerated(value = EnumType.STRING)
	private Provincia provincia;
	
	private int codigoPostal;
	
	
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
	
}
