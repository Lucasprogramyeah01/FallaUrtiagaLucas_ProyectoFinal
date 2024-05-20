package com.salesianostriana.dam.fallaurtiagalucasproyectofinal1dam.modelo;

public enum Publico {
	Infantil("Infantil (entre 3 y 10 años)"),
	Juvenil("Juvenil (entre 11 y 17 años)"),
	Adulto("Adulto (para mayores de 18 años)");
	
	private final String nombrePublico;
	
	private Publico (String nombrePublico) {
		this.nombrePublico = nombrePublico;
	}
	
	public String getNombrePublico() {
		return nombrePublico;
	}
}
