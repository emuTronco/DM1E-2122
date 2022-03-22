package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplo02cadenasmemoria;

import java.io.IOException;
import java.io.StringReader;

/**
 * 
 * Ejemplo de uso del método skip para saltar una secuencia de caracteres en un fichero
 *
 */
public class Ejemplo04 {
	private static int NUM_CHAR_SALTAR= 10;

	public static void main(String[] args) throws IOException {
		String cadenaConContenido = "Esta cadena la podemos procesar como un stream.";
		StringReader reader = new StringReader(cadenaConContenido);
		int code;
		System.out.println("Vamos a saltar");
		reader.skip(NUM_CHAR_SALTAR);
		while ((code = reader.read()) != -1) {
			System.out.println((char) code);
		}
		// No es imprescindible cerrar el reader de forma explícita porque no reserva
		// recursos como ficheros o sockets de comunicaciones, pero no pasa nada si se
		// cierra.
		reader.close();
	}
}
