package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio09 {

	// Crea manualmente (con un editor de texto) un fichero llamado “nombres.txt”
	// con una lista de personas, cada una con nombre y apellidos.

	// Crea un programa Java que lea el fichero “nombres.txt”, y calcule a longitud
	// media de los nombres completos (nombre + apellido). Muestra el contenido de
	// dicho fichero por pantalla de forma que para cada pareja de nombre y apellido
	// se muestre su longitud y al final la media de las longitudes de los
	// nombres+apellido.

	private static final String NOM_FICHERO = "FicherosPrueba/nombres.txt";
	
	public static void main(String[] args) {
		// Vamos a usar BufferedReader para aprovechar que se pueden leer líneas completas.
		try(FileReader fr = new FileReader(NOM_FICHERO); BufferedReader br = new BufferedReader(fr)){
			int longitudTotal = 0;
			int numLineas = 0;
//			String linea = br.readLine();
//			while (linea != null) {
//				numLineas++;
//				longitudTotal += linea.length();
//				System.out.printf("%s -- %d\n", linea, linea.length());
//				linea = br.readLine();
//			}
			
			String linea;
			while ((linea = br.readLine()) != null) {
				numLineas++;
				longitudTotal += linea.length();
				//longitudTotal += linea.replace(" ", "").length();

				System.out.printf("%s -- %d\n", linea, linea.length());
				System.out.printf("%s -- %d\n", linea, linea.replace(" ", "").length());
			}			
			
			System.out.println("Longitud media: " + ((double)longitudTotal)/((double)numLineas));
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Error al abir el fichero. No se ha encontrado el fichero " + NOM_FICHERO);
		} catch (IOException e) {
			System.out.println("Error de E/S al leer el fichero.");
		}


	}

}
