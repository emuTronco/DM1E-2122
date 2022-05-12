package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos05aleatorios;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * 
 * Ejemplo de ficheros aleatorios. Este programa abre el fichero que se ha
 * generado en el ejemplo anterior y lo modifica duplicando los números pares
 * que encuentre.
 *
 */
public class Ejemplo17Aleatorio02 {

	private static final String PATH_FICHERO = "FicherosPrueba" + File.separator + "ejemplo-acceso-aleatorio-01.dat";
	private static Random rnd = new Random();

	public static void main(String args[]) {
		mostrarContenidoFichero();
		duplicarPares();
		mostrarContenidoFichero();
	}

	private static void duplicarPares() {
		try (RandomAccessFile raf = new RandomAccessFile(PATH_FICHERO, "rw")) {
			// Como los métodos para leer enteros no devuelven -1 al llegar al final hay que
			// controlarlo con la excepción EOFException y un boolean
			boolean eof = false;

			while (!eof) {

				try {
					// Leemos el entero en la posición actual
					int numero = raf.readInt();
					// Comprobamos si es par
					if (numero % 2 == 0) {
						System.out.printf("Encontrado valor par (%d) en la posición %d del fichero.\n", numero,
								raf.getFilePointer());
						// Para sobrescribirlo con el doble hay que volver atrás el tamaño de un número
						// entero en bytes.
						System.out.printf("Saltando %d bytes atrás.\n", Integer.BYTES);
						if (raf.skipBytes(-(Integer.BYTES)) == Integer.BYTES) {
							System.out.printf("Salto OK.\n", Integer.BYTES);
						} else {
							System.out.printf("Salto KO.\n", Integer.BYTES);
						}

						// Escribimos el número duplicado. Al hacerlo avanzamos al mismo punto en que
						// estábamos antes de volver atrás.
						System.out.printf("Escribiendo el valor duplicado (%d * 2) en la posición %d del fichero.\n",
								numero, raf.getFilePointer());
						raf.writeInt(numero * 2);
					}
				} catch (EOFException e) {
					eof = true;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
		} catch (IOException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
			e.printStackTrace();
		}
	}

	private static void mostrarContenidoFichero2() {
		try (RandomAccessFile raf = new RandomAccessFile(PATH_FICHERO, "r")) {
			// Como los métodos para leer enteros no devuelven -1 al llegar al final hay que
			// controlarlo con la excepción EOFException y un boolean
			boolean eof = false;
			while (!eof) {
				try {
					// Leemos el entero en la posición actual
					int numero = raf.readInt();
					System.out.printf("%d ", numero);
				} catch (EOFException e) {
					eof = true;
				}
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
		} catch (IOException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
			e.printStackTrace();
		}
	}

	private static void mostrarContenidoFichero() {
		try (RandomAccessFile raf = new RandomAccessFile(PATH_FICHERO, "r")) {
			// Como los métodos para leer enteros no devuelven -1 al llegar al final hay que
			// controlarlo con la excepción EOFException y un boolean
			while (true) {
				// Leemos el entero en la posición actual
				int numero = raf.readInt();
				System.out.printf("%d ", numero);
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
		} catch (IOException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
			e.printStackTrace();
		}
		System.out.println();
	}
}