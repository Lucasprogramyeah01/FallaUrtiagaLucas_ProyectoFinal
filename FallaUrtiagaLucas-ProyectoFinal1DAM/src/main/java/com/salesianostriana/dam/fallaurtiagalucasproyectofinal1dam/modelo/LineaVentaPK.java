package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class LineaVentaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idLineaVenta;
	
	private Venta venta;

}
