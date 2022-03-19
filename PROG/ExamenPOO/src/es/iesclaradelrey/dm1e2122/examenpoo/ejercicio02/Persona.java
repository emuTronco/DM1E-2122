package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio02;

public class Persona {
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	public Persona(String dni, String nombre, String apellido1, String apellido2) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public Persona(String dni, String nombre, String apellido1) {
		this (dni, nombre, apellido1, "");
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	@Override
	public String toString() {
		return "Persona: " + dni + " / " + nombre + " " + apellido1 + " " + apellido2; 
	}
}
