package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio10Scanner {

	// Crea manualmente (con un editor de texto) un fichero llamado “nombres.txt”
	// con una lista de personas, cada una con nombre y apellidos.

	// Crea un programa Java que lea el fichero “nombres.txt”, y calcule a longitud
	// media de los nombres o apellidos (longitud media de las distintas palabras).
	// Muestra el contenido de dicho fichero por pantalla de forma que para cada
	// línea con nombres y apellidos se muestre su longitud y al final la media de
	// las longitudes de los nombres / apellidos.

	private static final String NOM_FICHERO = "FicherosPrueba/nombres.txt";

	public static void main(String[] args) {
		// Vamos a usar BufferedReader para aprovechar que se pueden leer líneas
		// completas.
		try (FileReader fr = new FileReader(NOM_FICHERO); Scanner sc = new Scanner(fr)) {
			int longitudTotal = 0;
			int numPalabras = 0;

			
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] palabras = linea.split(" ");
				for (String palabra : palabras) {
					String palabraSinEspacios = palabra.trim();
					if (palabraSinEspacios.length() > 0) {
						numPalabras++;
						longitudTotal += palabraSinEspacios.length();
					}
					System.out.printf("%s -- %d\n", linea, linea.length());
				}
			}
			System.out.println("Longitud media: " + ((double) longitudTotal) / ((double) numPalabras));
		} catch (FileNotFoundException e) {
			System.out.println("Error al abir el fichero. No se ha encontrado el fichero " + NOM_FICHERO);
		} catch (IOException e) {
			System.out.println("Error de E/S al leer el fichero.");
		}

	}

}
