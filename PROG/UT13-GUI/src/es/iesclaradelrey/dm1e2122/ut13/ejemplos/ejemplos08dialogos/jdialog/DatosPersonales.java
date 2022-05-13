package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos08dialogos.jdialog;

import java.time.LocalDate;

public class DatosPersonales {
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;

	public DatosPersonales(String nombre, String apellidos, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Datos personales: " + nombre + " " + apellidos + ". Fecha de nacimiento: " + fechaNacimiento;
	}

}
