package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos03basicos;

import java.io.IOException;
import java.io.PrintWriter;

public class Ejemplo09CierreStreamEstandar {

	public static void main(String[] args) throws IOException {
		sinTryWithResources();
		conTryWithResources();
	}

	private static void sinTryWithResources() {
		System.out.println("Abriendo un PrintStream que usa System.out como Stream subyacente.");

		// Usamos un try-with-resources. Esto provocará el cierre del stream subyacente
		// y nos impedirá seguir trabajando con él.
		PrintWriter pw = new PrintWriter(System.out);
		pw.println("Línea 1.");
		pw.println("Línea 2.");
		pw.println("Línea 3.");
		pw.println("Línea 4.");
		pw.println("Línea 5.");
		pw.println("Línea 6.");

		// Como no estamos cerrando el stream, hay que forzar que se muestre. En
		// cualquier caso se mostrará cuando finalice el programa.
		pw.flush();

		// Esto no da error porque la mayoría de los métodos de PrintStream no producen
		// error.
		System.out.println("Este texto sí saldrá...");
	}

	private static void conTryWithResources() {
		System.out.println("Abriendo un PrintStream que usa System.out como Stream subyacente.");

		// Usamos un try-with-resources. Esto provocará el cierre del stream subyacente
		// y nos impedirá seguir trabajando con él.
		try (PrintWriter pw = new PrintWriter(System.out)) {
			pw.println("Línea 1.");
			pw.println("Línea 2.");
			pw.println("Línea 3.");
			pw.println("Línea 4.");
			pw.println("Línea 5.");
			pw.println("Línea 6.");
		}

		// Esto no da error porque la mayoría de los métodos de PrintStream no producen
		// error.
		System.out.println("Este texto no debe salir ya...");
	}
}
