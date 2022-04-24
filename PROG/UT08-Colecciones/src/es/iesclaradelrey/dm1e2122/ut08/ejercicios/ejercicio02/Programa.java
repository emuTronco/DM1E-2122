package es.iesclaradelrey.dm1e2122.ut08.ejercicios.ejercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	private static Scanner sc = new Scanner(System.in);

	private static final String[] OPCIONES_MENU = { "1 - Listar alumnos", "2 - Añadir alumno", "3 - Eliminar alumno",
			"4 - Mostrar alumno", "0 - Salir" };

	public static void main(String[] args) {
		List<Alumno> alumnos = new ArrayList<>();
		String opcionElegida = null;
		do {
			opcionElegida = mostrarMenu();
			switch (opcionElegida) {
			case "1":
				listarAlumnos(alumnos);
				break;
			case "2":
				addAlumno(alumnos);
				break;
			case "3":
				delAlumno(alumnos);
				break;
			case "4":
				showAlumno(alumnos);
				break;
			}
		} while (!opcionElegida.equals("0"));

	}

	private static void listarAlumnos(List<Alumno> alumnos) {
		for (Alumno alumno : alumnos) {
			System.out.println(alumno);
		}
		esperarEnter();
	}

	private static void addAlumno(List<Alumno> alumnos) {
		String nifNie, nombre, apellidos, ciclo, fechaNac;
		System.out.println("Introduce los datos del alumno:");
		System.out.print("Nombre: ");
		nombre = sc.nextLine();
		System.out.print("Apellidos: ");
		apellidos = sc.nextLine();
		System.out.print("NIF / NIE: ");
		nifNie = sc.nextLine();
		System.out.print("Ciclo: ");
		ciclo = sc.nextLine();
		System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
		fechaNac = sc.nextLine();

		Alumno nuevo = new Alumno(nifNie, nombre, apellidos, ciclo, fechaNac);

		if (alumnos.contains(nuevo)) {
			System.out.println("Ya existe el alumno.");
		} else {
			alumnos.add(nuevo);
		}
		esperarEnter();
	}

	private static void delAlumno(List<Alumno> alumnos) {
		System.out.println("Introduce el NIF / NIE del alumno que deseas eliminar: ");
		String nifNie = sc.nextLine();
		int posicion = alumnos.indexOf(new Alumno(nifNie));
		if (posicion < 0) {
			System.out.printf("No se encuentra el alumno con NIF / NIE %s.\n", nifNie);
		} else {
			alumnos.remove(posicion);
			System.out.println("Alumno eliminado.");
		}
		esperarEnter();
	}

	private static void showAlumno(List<Alumno> alumnos) {
		System.out.println("Introduce el NIF / NIE del alumno que deseas mostrar: ");
		String nifNie = sc.nextLine();
		int posicion = alumnos.indexOf(new Alumno(nifNie));
		if (posicion < 0) {
			System.out.printf("No se encuentra el alumno con NIF / NIE %s.\n", nifNie);
		} else {
			Alumno alumno = alumnos.get(posicion);
			System.out.println(alumno.toFormattedString());
			
		}
		esperarEnter();
	}

	private static void esperarEnter() {
		System.out.println("Presiona Intro para continuar...");
		sc.nextLine();
	}

	private static String mostrarMenu() {
		System.out.println("\n");
		for (String opcion : OPCIONES_MENU) {
			System.out.println(opcion);
		}
		System.out.print("Elige una  opción: ");
		return sc.nextLine();
	}

}
