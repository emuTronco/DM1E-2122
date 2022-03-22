package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplo02cadenasmemoria;

import java.io.IOException;
import java.io.StringReader;

/**
 * 
 * Ejemplo del uso de mark y
 *
 */
public class Ejemplo05 {
	private static int NUM_CHAR_SALTAR = 10;

	public static void main(String[] args) throws IOException {
		String cadenaConContenido = "Esta cadena la podemos procesar como un stream.";
		StringReader reader = new StringReader(cadenaConContenido);

		int code;
		int posicion = 0;

		// Leemos 10 caracteres
		System.out.println("Leyendo 10 caracteres...");
		while (((code = reader.read()) != -1) && posicion < 10) {
			System.out.println((char) code);
			posicion++;
		}

		// Marcamos la posición
		System.out.println("Marcando posición...");
		// En los StringReaders este parámetro puede ser 0, porque en realidad se
		// ignora. Es el límite de caracteres que se pueden leer después de la marca sin
		// perderla. Simplemente no puede ser negativo.
		reader.mark(0);
		
		// Leemos hasta el final
		System.out.println("Leyendo hasta el final...");
		while ((code = reader.read()) != -1) {
			System.out.println((char) code);
		}

		// Volvemos a la posición marcada
		System.out.println("Volviendo a posición marcada...");
		reader.reset();

		// Leemos hasta el final
		System.out.println("Leyendo hasta el final de nuevo...");
		while ((code = reader.read()) != -1) {
			System.out.println((char) code);
		}
		
		// No es imprescindible cerrar el reader de forma explícita porque no reserva
		// recursos como ficheros o sockets de comunicaciones, pero no pasa nada si se
		// cierra.
		reader.close();
	}
}
