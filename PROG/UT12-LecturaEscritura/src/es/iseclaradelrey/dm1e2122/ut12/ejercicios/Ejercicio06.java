package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ejercicio06 {

	// Crea un programa en Java que lea el fichero credo en el ejercicio 05, y
	// genere otro llamado “parrafoSinVocales.txt”, que tenga el mismo contenido.
	// Pero sin las vocales. Sean mayúsculas o minúsculas. Para practicar, aunque
	// puede que haya formas más eficientes de hacerlo, puedes usar un conjunto
	// (SET) para comprobar si una letra del fichero original es una vocal.

	private static final String NOM_FICHERO = "FicherosPrueba" + File.separator + "parrafo.txt";
	private static final String NOM_FICHERO_SALIDA = "FicherosPrueba" + File.separator + "parrafoSinVocales.txt";

	// Definimos un array para cargar el conjunto de vocales. Así no hay que hacer
	// múltiples add en el conjunto.
	private static final Character[] ARRAY_VOCALES = { 'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'A', 'E', 'I',
			'O', 'U', 'Á', 'É', 'Í', 'Ó', 'Ú' };
	// Creamos el conjunto de vocales con el constructor que recibe una colección de
	// elementos para inicializarlo. Usamos un método estático de utilidad de la
	// clase Arrays para convertir el array de vocales en una colección (una lista,
	// para ser exactos).
	private static final Set<Character> VOCALES = new HashSet<>(Arrays.asList(ARRAY_VOCALES));

	public static void main(String[] args) throws IOException {
		// Usamos try-with-resources para que los dos streams (reader y writer) se
		// cierren automáticamente al salir del bloque.
		try (FileReader fr = new FileReader(NOM_FICHERO); 
				FileWriter fw = new FileWriter(NOM_FICHERO_SALIDA)) {
			int c;
			// Leemos hasta que se ha alcanzado el fin del fichero
			while ((c = fr.read()) != -1) {
				if (!VOCALES.contains((char) c)) {
					// Escribimos en el fichero de salida sólo si no es una vocal.
					fw.write(c);
				}
			}
			
			// Este código es equivalente al de arriba, pero menos compacto.
//			c = fr.read();
//			while (c != -1) {
//				if (!VOCALES.contains((char) c)) {
//					// Escribimos en el fichero de salida sólo si no es una vocal.
//					fw.write(c);
//				}
//				c = fr.read();
//			}
		}
	}
}
