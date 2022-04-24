package es.iesclaradelrey.dm1e2122.ut08.ejercicios.ejercicio04;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	private static final String[] OPCIONES_MENU = { "A Mostrar contenido de la lista.",
			"B Mostrar el elemento en una posición concreta de la lista.",
			"C Agregar un número al principio de la lista.", "D Agregar un número al final de la lista.",
			"E Añadir un número en una posición concreta de la lista. ",
			"F Eliminar un número del principio de la lista.", "G Eliminar un número del final de la lista.",
			"H Eliminar un número de una posición concreta de la lista.",
			"I Eliminar un número de la lista (no de la posición, sino el número). Deberá eliminarlo todas las veces que aparezca.",
			"J Ordenar la lista de forma creciente.", "K Ordenar la lista de forma decreciente.",
			"L Verificar si la lista está ordenada de forma ascendente.",
			"M Verificar si la lista está ordenada de forma descendente.",
			"N Mostrar n elementos de la lista (desde la posición n, y cuantos).", "O Obtener el máximo de la lista.",
			"P Obtener el mínimo de la lista.", "Q Invertir la lista.", "R Desordenar la lista. ",
			"S Salir del programa." };

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		LinkedList<String> lista = new LinkedList<>();
		
		lista.add("Primero");
		lista.add("Segundo");
		lista.add("Tercero");
		lista.add("Cuarto");
		lista.add("Quinto");
		lista.add("Sexto");

		char opcionElegida;

		do {

			opcionElegida = menu();

			switch (opcionElegida) {
			case 'A':
				System.out.println(lista);
				break;
			case 'B':
				mostrarElementoPosicion(lista);
				break;
			case 'C':
				addPrincipio(lista);
				break;
			case 'D':
				addFinal(lista);
				break;
			case 'E':
				break;
			case 'F':
				break;
			case 'G':
				break;
			case 'H':
				break;
			case 'I':
				break;
			case 'J':
				Collections.sort(lista);
				break;
			case 'K':
				Collections.sort(lista, Collections.reverseOrder());
				break;
			case 'L':
				break;
			case 'M':
				break;
			case 'N':
				break;
			case 'O':
				break;
			case 'P':
				break;
			case 'Q':
				break;
			case 'R':
				break;
			case 'S':
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opcionElegida != 'S');

	}

	private static void addFinal(LinkedList<String> lista) {
		System.out.print("¿Qué texto quieres añadir? ");
		String texto = sc.nextLine();
		lista.addLast(texto);
	}

	private static void addPrincipio(List<String> lista) {
		System.out.print("¿Qué texto quieres añadir? ");
		String texto = sc.nextLine();
		lista.add(0, texto);
		//lista.addFirst(texto);
	}

	private static void mostrarElementoPosicion(List<String> lista) {
		System.out.print("¿Qué posición de la lista quieres ver? ");
		int posicion = Integer.parseInt(sc.nextLine());
		if (posicion <0 || posicion >= lista.size()) {
			System.out.println("La posición está fuera de los límites.");
		}
		else {
			System.out.println("El valor de la posición " + posicion + " es " + lista.get(posicion));
		}
	}

	private static char menu() {
		for (String opcion : OPCIONES_MENU) {
			System.out.println(opcion);
		}
		// Comprobar que ha introducido una opción válida.
		System.out.println("Elija la opción");
		String respuesta = sc.nextLine();
		return respuesta.toUpperCase().charAt(0);
	}

}
