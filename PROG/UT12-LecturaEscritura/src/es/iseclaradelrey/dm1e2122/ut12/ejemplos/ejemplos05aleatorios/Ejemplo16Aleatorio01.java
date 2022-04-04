package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos05aleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * 
 * Ejemplo de ficheros aleatorios. Este programa escribe 20 números enteros
 * aleatorios en el fichero, y luego los lee sin cerrar y volver a abrir el
 * fichero.
 *
 */
public class Ejemplo16Aleatorio01 {

	private static final int CANTIDAD_NUMEROS = 20;
	private static final int MAX_VALOR = 100;
	private static final String PATH_FICHERO = "FicherosPrueba" + File.separator + "ejemplo-acceso-aleatorio-01.dat";
	private static Random rnd = new Random();

	public static void main(String args[]) {
		try (RandomAccessFile raf = new RandomAccessFile(PATH_FICHERO, "rw")) {
			// Escribir los números
			for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
				int numero = rnd.nextInt(MAX_VALOR + 1);
				System.out.println("Escribiendo " + numero);
				raf.writeInt(numero);
			}

			// Comprobar tamaño del fichero
			System.out.println("Tamaño del fichero (en bytes): " + raf.length());

			// Saltamos al inicio del fichero
			raf.seek(0);

			// Leemos el primer número
			System.out.print("En la posicion " + raf.getFilePointer());
			System.out.println(" está el número " + raf.readInt());

			// Leemos una segunda vez
			System.out.println("Realizamos una segunda lectura sin alterar el puntero de acceso. ");
			System.out.print("En la posicion " + raf.getFilePointer());
			System.out.println(" está el número " + raf.readInt());

			// Saltamos 9 enteros. Integer.Bytes sólo está disponible desde la versión 8 de
			// Java. Si se usa Java 7 o anterior, usar directamente una constante con el
			// valor 4 (un entero ne java son 32 bits, u 8 bytes).
			raf.skipBytes(9 * Integer.BYTES); // Salto 9 => Elemento 10 más allá
			//raf.skipBytes(9 * 4); // Salto 9 => Elemento 10 más allá
			System.out.print("10 elementos más allá, en la posición " + raf.getFilePointer() + " está el ");
			System.out.println(raf.readInt());
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
		} catch (IOException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
			e.printStackTrace();
		}
	}
}
