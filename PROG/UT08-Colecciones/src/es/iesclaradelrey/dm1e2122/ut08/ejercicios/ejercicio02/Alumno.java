package es.iesclaradelrey.dm1e2122.ut08.ejercicios.ejercicio02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Alumno {
	private String nifNie;
	private String nombre;
	private String apellidos;
	private String cicloFormativo;
	private LocalDate fechaNacimiento;

	public Alumno(String nifNie) {
		this.nifNie = nifNie;
	}
	
	public Alumno(String nifNie, String nombre, String apellidos, String cicloFormativo, String fechaNacimiento) {
		this.nifNie = nifNie;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cicloFormativo = cicloFormativo;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alumno [nifNie=");
		builder.append(nifNie);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", cicloFormativo=");
		builder.append(cicloFormativo);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nifNie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nifNie, other.nifNie);
	}

	public String toFormattedString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alumno (");
		builder.append(nifNie);
		builder.append(")");
		builder.append("\n\t Nombre: ");
		builder.append(nombre);
		builder.append("\n\t Apellidos: ");
		builder.append(apellidos);
		builder.append("\n\t Ciclo formativo: ");
		builder.append(cicloFormativo);
		builder.append("\n\t Fecha de nacimiento: ");
		builder.append(fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return builder.toString();
	}
	
	
}