package es.iesclaradelrey.dm1e2122.examencolecciones.ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SecretariaRevision {
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

	////////////////////

	// Comprobaciones reiteradas dentro del bucle. Se muestran múltiples mensajes.
	public void eliminarAlumno01(String dni) {

		for (Iterator<Alumno> iterator = alumnos.iterator(); iterator.hasNext();) {
			Alumno next = iterator.next();
			if (!dni.equals(next.getDni())) {
				System.out.println("El alumno no existe");
			} else if (dni.equals(next.getDni())) {
				iterator.remove();
				System.out.println("El alumno se elimino correctamente");
			}
		}
	}

	// Asumir que una lista está ordenada. Puede no estarlo.
	public void listarPorDniDescendiente001() {
		Collections.reverse(alumnos);
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i).toString());
		}
	}

	// Bucles con i más complejos que foreach.
	public void redondearNota() {
		for (int i = 0; i < alumnos.size(); i++) {
			alumnos.get(i).setNotaMedia((double) Math.round(alumnos.get(i).getNotaMedia()));
		}

	}

	public void redondearNota00() {
		for (int i = 0; i < alumnos.size(); i++) {
			alumnos.get(i).setNotaMedia((double) Math.round(alumnos.get(i).getNotaMedia()));
		}

	}

	// Simplificar esto usando el constructor de ArrayList que recibe colección.
	public void listarPorDni001() {
		var alumnado = new HashMap<String, Alumno>();
		System.out.println();
		System.out.println();
		System.out.println("Listado de alumnos por DNI");
		System.out.println(alumnado);
		ArrayList<Alumno> array = new ArrayList<Alumno>();
		array.addAll(alumnado.values());
		array.sort(null);
		for (var alumno : array) {
			System.out.println(alumno);
		}
	}

	// Llamamos varias veces a un constructor...
	public void addAlumno001(String dni, String nombre, String apellidos, String fechaNacimiento, double notaMedia) {

		if (!alumnos.contains(new Alumno(dni, nombre, apellidos, fechaNacimiento, notaMedia))) {
			alumnos.add(new Alumno(dni, nombre, apellidos, fechaNacimiento, notaMedia));
			System.out.println("\nAñadido alumno con DNI " + dni);
		} else
			System.out.println("Error. El alumno ya está registrado");
	}

	// Añadir siempre. Al ser un set no duplica, pero muestra mensaje cuando no
	// debiera.
	public void addAlumno002(String dni, String nombre, String apellidos, String fechaNacimiento, double notaMedia) {

		var alumnos = new HashSet<Alumno>();

		boolean encontrado = false;

		for (Alumno a : alumnos) {

			if (a.getDni().equals(dni)) {
				System.out.println("el alumno con la nif " + dni + " ya existe");
				encontrado = true;
			}
		}

		if (!encontrado) {
			alumnos.add(new Alumno(dni, nombre, apellidos, fechaNacimiento, notaMedia));
			System.out.println("añadido alumno con DNI " + dni);
		}

	}

	// Optimizable, si paramos el bucle o usamos iterador.
	public void cambiarNotaAlumno001(String dni, double nuevaMedia) {
		boolean existe = false;
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				existe = true;
			}
		}
		if (existe == true) {
			for (int i = 0; i < alumnos.size(); i++) {
				if (alumnos.get(i).getDni() == dni) {
					alumnos.get(i).setNotaMedia(nuevaMedia);
					System.out.println("Modificada la nota del alumno con DNI " + alumnos.get(i).getDni());
				}
			}
		} else {
			System.out.println("No se ha encontrado el alumno con el DNI" + dni);
		}
	}

	// Error en la comparación, y mensajes de más en la consola.
	public void cambiarNotaAlumno0003(String d, double nota) {
		for (Alumno al : alumnos) {
			if (al.getDni() == d) {
				al.setNotaMedia(nota);
				System.out.println("Modificada la nota del alumno con DNI " + d);
			} else {
				System.out.println("No se ha encontrado al alumno con DNI " + d);
			}
		}
	}

}
