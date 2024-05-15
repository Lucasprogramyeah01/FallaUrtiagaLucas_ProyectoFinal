package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

public enum Cubierta {
	TapaBlanda("Tapa blanda"),
	TapaDura("Tapa dura"),
	Sobrecubierta("Sobrecubierta");
	
	private final String displayValue;
	
	private Cubierta (String displayValue) {
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
}
