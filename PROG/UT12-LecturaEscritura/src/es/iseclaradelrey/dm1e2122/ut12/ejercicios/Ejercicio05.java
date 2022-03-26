package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio05 {

	// Crea un programa en Java que cree un fichero de texto llamado “parrafo.txt”.
	// El programa pedirá al usuario que escriba líneas de texto por pantalla, y las
	// escribirá en el fichero, hasta que el usuario escriba una línea que sólo
	// tenga la palabra “FIN”, en mayúsculas.

	private static final String NOM_FICHERO = "FicherosPrueba/parrafo.txt";

	public static void main(String[] args) throws IOException {
		//conFileWriter();
		conPrintWriter();

	}

	// Primera versión. Usamos un FileWriter. Como esta clase no tiene un método
	// para añadir una línea, que incluya el salto de línea, tenemos que añadirlo
	// manualmente al final de cada línea leída del scanner.
	private static void conFileWriter() throws IOException {
		System.out.println("Introduce el texto que quieras escribir en el fichero.");

		try (Scanner sc = new Scanner(System.in); FileWriter fw = new FileWriter(NOM_FICHERO)) {
			String linea;
			do {
				linea = sc.nextLine();
				if (!linea.equals("FIN")) {
					fw.write(linea + "\n");
				}
			} while (!linea.equals("FIN"));
		}
	}

	// Segunda versión. Usamos un PrintWriter. Esta clase tiene métodos que permiten
	// escribir líneas completas y distintos tipos de objeto.
	private static void conPrintWriter() throws IOException {
		System.out.println("Introduce el texto que quieras escribir en el fichero.");

		try (Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(NOM_FICHERO)) {
			String linea;
			do {
				linea = sc.nextLine();
				if (!linea.equals("FIN")) {
					pw.println(linea);
				}
			} while (!linea.equals("FIN"));
		}
	}

}
