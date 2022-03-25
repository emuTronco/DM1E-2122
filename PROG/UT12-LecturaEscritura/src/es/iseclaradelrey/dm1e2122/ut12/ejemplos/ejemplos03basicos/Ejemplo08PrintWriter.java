package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos03basicos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejemplo08PrintWriter {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Primero sin autoflush.");

		// No usamos un try-with-resources porque estamos usando como stream System.out.
		// Si lo usamos, el stream se cierra al acabar y ya no podemos usarlo.
		PrintWriter pw = new PrintWriter(System.out);
		pw.println("Línea 1 - Sin autoflush.");
		pw.println("Línea 2 - Sin autoflush.");
		pw.println("Línea 3 - Sin autoflush.");
		pw.println("Línea 4 - Sin autoflush.");
		pw.println("Línea 5 - Sin autoflush.");
		pw.println("Línea 6 - Sin autoflush.");

		// Paramos hasta que el usuario pulse enter.
		sc.nextLine();

		pw.flush();

		System.out.println("Ahora con autoflush.");

		// No usamos un try-with-resources porque estamos usando como stream System.out.
		// Si lo usamos, el stream se cierra al acabar y ya no podemos usarlo.
		PrintWriter pw1 = new PrintWriter(System.out, true);
		pw1.println("Línea 1 - Con autoflush.");
		pw1.println("Línea 2 - Con autoflush.");
		pw1.println("Línea 3 - Con autoflush.");
		pw1.println("Línea 4 - Con autoflush.");
		pw1.println("Línea 5 - Con autoflush.");
		pw1.println("Línea 6 - Con autoflush.");

		// Paramos hasta que el usuario pulse enter.
		sc.nextLine();

		System.out.println("Fin del programa.");

	}

}
