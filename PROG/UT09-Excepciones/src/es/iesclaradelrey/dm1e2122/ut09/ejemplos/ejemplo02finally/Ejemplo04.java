package es.iesclaradelrey.dm1e2122.ut09.ejemplos.ejemplo02finally;

import java.util.Scanner;

/**
 * Ejemplo de finally con un return. Demostración de que SIEMPRE se ejecuta. En cualquier caso.
 */
public class Ejemplo04 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int i = 0;
		do {
			System.out.println("Introduce un número. -9 para terminar.");
			i = pideValorConFinally();
			System.out.println("Número introducido: " + i);
		} while (i != -9);

		System.out.println("Fin del programa");

	}

	
	private static int pideValorConFinally() {
		try {
			int i = Integer.parseInt(sc.nextLine());
			return i;
		} catch (Exception e) {
			System.out.println("Error. No es un número.");
			return 0;
		} finally {
			// El IDE muestra un warning porque no es "normal" hacer return en un finally.
			System.out.println("En finally.");
			return -1;
		}
	}
}
