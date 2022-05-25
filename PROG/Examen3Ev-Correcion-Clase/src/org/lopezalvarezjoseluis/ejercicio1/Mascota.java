package org.lopezalvarezjoseluis.ejercicio1;

import java.io.Serializable;

public class Mascota implements Serializable {

	private static final long serialVersionUID = 1L;

	String nombre;
	String especie;
	String raza;
	int edad;

	public Mascota(String nombre, String especie, String raza, int edad) {
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public String getRaza() {
		return raza;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", especie=" + especie + ", raza=" + raza + ", edad=" + edad + "]";
	}
}
