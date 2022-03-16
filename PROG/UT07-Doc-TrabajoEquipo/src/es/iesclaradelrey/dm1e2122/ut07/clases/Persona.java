package es.iesclaradelrey.dm1e2122.ut07.clases;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;


/**
 * Clase para gestión de personas.
 * Se utiliza para la gestión de persona y como clase base para alumnos.
 */
public class Persona implements Comparable<Persona> {
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento ;
	
	/**
	 * Crea un objeto de tipo Persona a partir de sus datos básicos.
	 * 
	 * @param dni Número de identificador del usuario
	 * @param nombre Nombre de la persona
	 * @param apellidos Apellidos de la persona
	 * @param fechaNacimiento Fecha de nacimiento
	 */
	public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		/* Esto es un comentario
		 * largo. No es JavaDoc.
		 * */
		super(); // Llamo al constructor de la superclase. Esto es un comentario poco útil
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		// 2022-03-15 - jllopezalvarez - Se cambia por asignación a parámetro, porque con null falla...
		// this.fechaNacimiento = null;
		this.fechaNacimiento = fechaNacimiento;
		
	}
	
	/**
	 * @return DNI de la persona
	 */
	public String getDni() {
		return dni;
	}

	// Si hemos documentado el get, y el set no necesita comentarios especiales, no hace falta documentarlo.
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * @return Nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return Apellidos de la persona.
	 */
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return Fecha de nacimiento de la persona
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	/**
	 * @return La edad de la persona, como el número de años completos que han pasado desde su nacimiento hasta hoy.
	 */
	public int edad() {
		Period periodo = Period.between(fechaNacimiento, LocalDate.now());  
		return periodo.getYears();
	}

	@Override
	/**
	 * Calcula el hashCode de la Persona teniendo en cuenta sólo el DNI, en mayúsculas. 
	 */
	public int hashCode() {
		String dniMays = dni == null ? null : dni.toUpperCase();
		return Objects.hash(dniMays);
	}

	@Override
	/**
	 * Dos objetos de la clase Persona son iguales si tienen el mismo DNI. No se diferencia entre mayúsculas y minúsculas. 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return dni.equalsIgnoreCase(other.dni);
	}

	@Override
	/**
	 * Compara dos personas según su DNI, sin diferenciar mayúsculas de minúsculas.
	 */
	public int compareTo(Persona o) {

		return this.dni.compareToIgnoreCase(o.dni);
	}

	
	
}
