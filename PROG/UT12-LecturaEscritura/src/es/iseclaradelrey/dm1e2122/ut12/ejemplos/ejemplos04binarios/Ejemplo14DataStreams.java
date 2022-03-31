package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos04binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ejemplo14DataStreams {
	// Ejemplo que genera una serie de parejas de números aleatorios.
	// El primer número de cada pareja será un entero de 0 a 99, y el segundo será
	// un doble de 0 a 1 millón (no incluido).
	// Estos números se almacenan como binarios en un fichero, y posteriormente se
	// leen y se muestran en consola.

	private static final String PATH_PRUEBAS = "FicherosPrueba";
	private static final String FICHERO_NUMEROS = PATH_PRUEBAS + File.separator + "paresNumeros.dat";
	private static final Random RND = new Random();
	private static final int NUM_PAREJAS = 10;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		generarFicheroNumeros();
		leerFicheroNumeros();
	}

	private static void generarFicheroNumeros() throws FileNotFoundException, IOException {
		System.out.printf("Generando %d parejas de números y guardándolas en el " 
															+ "fichero binario...\n",NUM_PAREJAS);

		try (DataOutputStream os = new DataOutputStream(new FileOutputStream(FICHERO_NUMEROS))) {
			for (int i = 0; i < NUM_PAREJAS; i++) {
				int entero = RND.nextInt(100);
				double doble = RND.nextDouble() * 1E6; // 1E6 = 1 * 10^6 = 1 millón
				System.out.printf("Pareja nº %d generada: %d %f\n", (i + 1), entero, doble);
				os.writeInt(entero);
				os.writeDouble(doble);
			}
		}

		System.out.println("Fichero guardado.");
	}

	private static void leerFicheroNumeros() throws FileNotFoundException, IOException {
		System.out.println("Leyendo parejas guardadas en el fichero binario...");

		try (DataInputStream is = new DataInputStream(new FileInputStream(FICHERO_NUMEROS))) {
			int numPareja = 1;
			boolean isEOF = false;
			while (!isEOF) {
				try {
					int entero = is.readInt();
					double doble = is.readDouble();
					System.out.printf("Pareja nº %d leída: %d, %f\n", numPareja, entero, doble);
					numPareja++;
				} catch (EOFException e) {
					// Se ha llegado al final del fichero
					isEOF = true;
				}
			}
		}
	}

}
