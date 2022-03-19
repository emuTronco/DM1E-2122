package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio02;

public class Estudiante extends Persona implements Comparable<Estudiante> {
	private double notaMedia;

	public Estudiante(String dni, String nombre, String apellido1, String apellido2, double notaMedia) {
		super(dni, nombre, apellido1, apellido2);
		this.notaMedia = notaMedia;
	}

	public Estudiante(String dni, String nombre, String apellido1, double notaMedia) {
		this(dni, nombre, apellido1, "", notaMedia);
	}
	
	@Override
	public String toString() {
		return "Estudiante: " + getDni() + " / " + getNombre() + " " + getApellido1() + " " + getApellido2() + " / Nota media: " + notaMedia; 
	}

	@Override
	public int compareTo(Estudiante otroEstudiante) {
		if (otroEstudiante == null) return -1;
		if (this.notaMedia < otroEstudiante.notaMedia) return -1;
		if (this.notaMedia == otroEstudiante.notaMedia) return 0;
		return 1;
	}
	
}
