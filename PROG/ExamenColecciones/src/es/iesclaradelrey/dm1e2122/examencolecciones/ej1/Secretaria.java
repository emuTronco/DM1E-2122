package es.iesclaradelrey.dm1e2122.examencolecciones.ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Secretaria {
	List<Alumno> alumnos = new ArrayList<>();

	public void addAlumno(String dni, String nombre, String apellidos, String fechaNacimiento, double notaMedia) {
		var buscado = buscarAlumno(dni);
		if (buscado == null) {
			this.alumnos.add(new Alumno(dni, nombre, apellidos, fechaNacimiento, notaMedia));
			System.out.println("\nAñadido alumno con DNI " + dni);
		} else {
			System.out.println("\nYa existe el alumno con DNI " + dni);
		}
	}

	public void eliminarAlumno(String dni) {
		var buscado = buscarAlumno(dni);
		if (buscado != null) {
			alumnos.remove(buscado);
			System.out.println("\nEliminado alumno con DNI " + dni);
		} else {
			System.out.println("\nNo se ha encontrado el alumno con DNI " + dni);
		}
	}

	public void cambiarNotaAlumno(String dni, double nota) {
		var buscado = buscarAlumno(dni);
		if (buscado != null) {
			buscado.setNotaMedia(nota);
			System.out.println("\nModificada la nota del alumno con DNI " + dni);
		} else {
			System.out.println("\nNo se ha encontrado el alumno con DNI " + dni);
		}
	}

	public void listarPorDni() {
		var alumnosOrdenados = new ArrayList<>(this.alumnos);
		Collections.sort(alumnosOrdenados);
		System.out.println("\n\nListado de alumnos por DNI");
		for (var alumno : alumnosOrdenados) {
			System.out.println(alumno);
		}
	}

	public void listarPorDniDescendente() {
		var alumnosOrdenados = new ArrayList<>(this.alumnos);
		Collections.sort(alumnosOrdenados, Comparator.reverseOrder());
		System.out.println("\n\nListado de alumnos por DNI - Descendente");
		for (var alumno : alumnosOrdenados) {
			System.out.println(alumno);
		}
	}

	public void listarPorNota() {
		var alumnosOrdenados = new ArrayList<>(this.alumnos);
		Collections.sort(alumnosOrdenados, new ByNotaAlumnoComparator());
		System.out.println("\n\nListado de alumnos por nota");
		for (Alumno alumno : alumnosOrdenados) {
			System.out.println(alumno);
		}
	}

	public void listarPorNotaDescendente() {
		var alumnosOrdenados = new ArrayList<>(this.alumnos);
		Collections.sort(alumnosOrdenados, new ByNotaAlumnoComparator().reversed());
		System.out.println("\n\nListado de alumnos por nota - Descendente");
		for (Alumno alumno : alumnosOrdenados) {
			System.out.println(alumno);
		}
	}

	public void listarPorFechaNacimiento() {
		var alumnosOrdenados = new ArrayList<>(this.alumnos);
		Collections.sort(alumnosOrdenados, new ByFechaNacAlumnoComparator());
		System.out.println("\n\nListado de alumnos por fecha de nacimiento");
		for (Alumno alumno : alumnosOrdenados) {
			System.out.println(alumno);
		}
	}

	public void listarPorFechaNacimientoDescendente() {
		var alumnosOrdenados = new ArrayList<>(this.alumnos);
		Collections.sort(alumnosOrdenados, new ByFechaNacAlumnoComparator().reversed());
		System.out.println("\n\nListado de alumnos por fecha de nacimiento - Descendente");
		for (Alumno alumno : alumnosOrdenados) {
			System.out.println(alumno);
		}
	}

	public void redondearNotas() {
		for (Alumno alumno : alumnos) {
			alumno.setNotaMedia(Math.round(alumno.getNotaMedia()));
		}
	}

	public void eliminarMenoresEdad() {
		var iterator = alumnos.iterator();
		while (iterator.hasNext()) {
			Alumno alumno = iterator.next();
			if (alumno.EsMenorEdad())
				iterator.remove();
		}
	}

	public void clear() {
		this.alumnos.clear();
	}

	private Alumno buscarAlumno(String dni) {
		// Versión con bucle
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni))
				return alumno;
		}
		return null;

		// Versión con métodos de listas
		// Alumno alumno = new Alumno(dni);
		// int posicion = this.alumnos.indexOf(alumno);
		// if (posicion < 0 ) return null;
		// return alumnos.get(posicion);

		// Versión funcional
		// var buscado = this.alumnos.stream().filter(a ->
		// a.getDni().equals(dni)).findFirst().orElse(null);
	}
}
