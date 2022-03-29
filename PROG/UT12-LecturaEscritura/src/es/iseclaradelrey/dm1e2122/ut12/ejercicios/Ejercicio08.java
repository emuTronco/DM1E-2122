package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio08 {

	private static final String NOM_ORIGEN = "FicherosPrueba/parrafo.txt";
	private static final String NOM_DESTINO = "FicherosPrueba/codificado.txt";

	// Crea un programa en Java que lea el fichero parrafo.txt y lo codifique
	// sumándole a cada letra un valor que se pedirá por teclado, guardarlo en otro
	// fichero denominado codificado.txt.
	// Leer el fichero creado y mostrarlo por pantalla.

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try (Scanner sc = new Scanner(System.in);
				FileReader fr = new FileReader(NOM_ORIGEN);
				FileWriter fw = new FileWriter(NOM_DESTINO)) {

			System.out.println("¿Cuánto quieres añadir a cada caracter?");
			int cantidad = Integer.parseInt(sc.nextLine());

			int c;
			while ((c = fr.read()) != -1) {
				if ((c != ' ') && (c != '\r') && (c != '\n'))
					c += cantidad;
				fw.write(c);
			}
		}

		mostrarFicheroCodificado();

	}

	private static void mostrarFicheroCodificado() throws FileNotFoundException, IOException {
		// En esta ocasión usamos un buffered reader para poder trabajar línea a
		// línea...
		try (FileReader fr = new FileReader(NOM_DESTINO); BufferedReader br = new BufferedReader(fr)) {
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
		}
	}

}
