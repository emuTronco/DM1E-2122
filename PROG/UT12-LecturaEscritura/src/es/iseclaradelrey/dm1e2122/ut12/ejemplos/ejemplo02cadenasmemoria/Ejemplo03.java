package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplo02cadenasmemoria;

import java.io.IOException;
import java.io.StringReader;

/**
 * 
 * Ejemplo básico de uso de StringReader.
 *
 */
public class Ejemplo03 {

	public static void main(String[] args) throws IOException {
		//sinFinally();
		conFinally();
	}

	private static void sinFinally() throws IOException {
		String cadenaConContenido = "Esta cadena la podemos procesar como un stream.";
		StringReader reader = new StringReader(cadenaConContenido);
		int code;
		while ((code = reader.read()) != -1) {
			System.out.println((char) code);
		}
		// No es imprescindible cerrar el reader de forma explícita porque no reserva
		// recursos como ficheros o sockets de comunicaciones, pero no pasa nada si se
		// cierra.
		reader.close();
	}

	private static void conFinally() throws IOException {
		String cadenaConContenido = "Esta cadena la podemos procesar como un stream.";
		StringReader reader = null;
		try {
			reader = new StringReader(cadenaConContenido);
			int code;
			while ((code = reader.read()) != -1) {
				System.out.println((char) code);
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

}
