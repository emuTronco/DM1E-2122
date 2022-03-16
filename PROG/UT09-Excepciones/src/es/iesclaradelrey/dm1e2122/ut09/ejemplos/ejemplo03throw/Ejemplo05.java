package es.iesclaradelrey.dm1e2122.ut09.ejemplos.ejemplo03throw;

import java.io.FileReader;
import java.io.IOException;

/**
 * Ejemplos de lanzado de excepciones con throw, delegación con throws y relanzado.
 */
public class Ejemplo05 {

	public static void main(String[] args) {

		lanzarUnchecked();

		try {
			lanzarChecked();
		} catch (Exception e) {
			System.out.println("Controlando excepción 'checked'");
			e.printStackTrace();
		}
	}

	public static void lanzarUnchecked() {
		// Comprobar algo que nos obliga a lanzar excepción
		// Y si se cumple se hace el throw
		throw new RuntimeException("Error de tipo 'unchecked'.");
	}

	public static void lanzarChecked() throws Exception {
		// Comprobar algo que nos obliga a lanzar excepción
		// Y si se cumple se hace el throw
		throw new Exception("Error de tipo 'checked'.");
	}

	// En este método la excepción no se controla, se delega usando "throws", con "s" 
	public static void delegacionExcepcion() throws IOException {
		var fr = new FileReader("fichero.txt");
		int num = fr.read();
		fr.close();
	}

	// En este método la excepción no se delega, se controla dentro del método.
	public static void delegacionExcepcion2() {
		try {
			var fr = new FileReader("fichero.txt");
			int num = fr.read();
			fr.close();

		} catch (IOException e) {

		}
	}

	public static void relanzadoDeExcepciones() {
		try {
			int i = Integer.parseInt("Número");
			System.out.println("El número introducido es " + i);
		} catch (Exception e) {
			System.err.println("Error al convertir a número. Relanzamos excepción.");
			throw e;
		}
	}

}
