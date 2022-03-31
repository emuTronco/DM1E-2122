package es.iesclaradelrey.dm1e2122.examencolecciones.ej1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Alumno implements Comparable<Alumno>{
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private double notaMedia;

	public Alumno(String dni, String nombre, String apellidos, String fechaNacimiento, double notaMedia) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.notaMedia = notaMedia;
	}

	public Alumno(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return dni;
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

	public double getNotaMedia() {
		return notaMedia;
	}
	
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public boolean EsMenorEdad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, hoy);
		return periodo.getYears() < 18;
	}

	@Override
	public String toString() {

		return dni + " - " + apellidos + " " + nombre + " - "
				+ fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
				" - " + notaMedia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getDni());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(getDni(), other.getDni());
	}

	@Override
	public int compareTo(Alumno o) {
		return this.getDni().compareTo(o.getDni());
	}


}
