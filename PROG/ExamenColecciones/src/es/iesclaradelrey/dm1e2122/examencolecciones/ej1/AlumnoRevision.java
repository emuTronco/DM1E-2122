package es.iesclaradelrey.dm1e2122.examencolecciones.ej1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AlumnoRevision implements Comparable<AlumnoRevision> {
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private double notaMedia;

	public AlumnoRevision(String dni, String nombre, String apellidos, String fechaNacimiento, double notaMedia) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.notaMedia = notaMedia;
	}

	public AlumnoRevision(String dni) {
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
				+ fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " + notaMedia;
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
		if (!(obj instanceof AlumnoRevision))
			return false;
		AlumnoRevision other = (AlumnoRevision) obj;
		return Objects.equals(getDni(), other.getDni());
	}

	@Override
	public int compareTo(AlumnoRevision o) {
		return this.getDni().compareTo(o.getDni());
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////

	// Dos veces la misma operación. Puede saltar excepción.
    public boolean equals001(Object o) {
        Alumno alumno = (Alumno) o;
        if (this.dni.equals(((Alumno) o).getDni())) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(dni, alumno.getDni());
    }
    
    // Asignación en lugar de comparación, no hace nada al llamar a super.
    public boolean equals002(Object dni) {
		if ((boolean) (dni=this.dni))   {
			return super.equals(dni);
		}else {
			return false;
		}
		
	}
    
    // Otro no hace nada con super
	public boolean equals003(Object obj) {
		return super.equals(dni);
	}
	
	

    // Complejidad innecesaria
    public int compareTo001(Alumno o) {
        if((this.dni.compareTo(o.getDni())) >= 1) return 1;
        if((this.dni.compareTo(o.getDni())) <= -1) return -1;
        return 0;
    }

    // Complejidad + inversión de lógica.
	public int compareTo002(Alumno a) {
		if (a.getDni().compareTo(this.getDni()) > 0) {
			return -1;
		} else if (a.getDni().compareTo(this.getDni()) == 0) {
			return 0;
		} else
			return 1;
	}
    
	// Comparación de dni caracter a caracter
	public int compareTo003(Alumno o) {
		String dniAux = ((Alumno) o).getDni();
		for (int i = 0; i < dni.length(); i++) {
			if (this.dni.charAt(i) > dniAux.charAt(i)) {
				return 1;
			} else if (this.dni.charAt(i) < dniAux.charAt(i)) {
				return -1;
			}
		}
		return 0;
	}
	
	
	

}
