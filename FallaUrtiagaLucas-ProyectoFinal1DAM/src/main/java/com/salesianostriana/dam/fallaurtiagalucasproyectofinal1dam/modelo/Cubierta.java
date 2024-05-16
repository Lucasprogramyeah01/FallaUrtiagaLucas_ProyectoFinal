package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

public enum Cubierta {
	TapaBlanda("Tapa blanda"),
	TapaDura("Tapa dura"),
	Sobrecubierta("Sobrecubierta");
	
	private final String nombreCubierta;
	
	private Cubierta (String nombreCubierta) {
		this.nombreCubierta = nombreCubierta;
	}
	
	public String getNombreCubierta() {
		return nombreCubierta;
	}
}
