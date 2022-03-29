package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ejercicio07B {
	// Crea manualmente (usando un editor de texto) dos ficheros f1.txt y f2.txt,
	// que tendrán un solo carácter por línea y que estarán ordenados
	// alfabéticamente.
	// Crea un programa en Java que genere el fichero f3.txt que será la fusión de
	// f1 y f2 manteniendo su ordenación.

	private static final String NOM_F1 = "FicherosPrueba/f1.txt";
	private static final String NOM_F2 = "FicherosPrueba/f2.txt";
	private static final String NOM_F3 = "FicherosPrueba/f3B.txt";

	private static final Character[] ARR_EXCLUIDOS = { ' ', '\n', '\r' };
	private static Set<Character> EXCLUIDOS = new HashSet<>(Arrays.asList(ARR_EXCLUIDOS));

	// Segunda versión. Vamos a intentar excluir los saltos de línea, y los
	// espacios.
	// Sólo para practicar usamos un diccionario para los caracteres excluidos.
	public static void main(String[] args) throws FileNotFoundException, IOException {

		combinarFicheros();
		mostrarFicheroCombinado();
	}

	private static void combinarFicheros() throws FileNotFoundException, IOException {
		// Abrimos los dos ficheros origen y creamos el de salida dentro de un
		// try-with-resources para garantizar que se cierran.
		try (FileReader f1 = new FileReader(NOM_F1);
				FileReader f2 = new FileReader(NOM_F2);
				FileWriter f3 = new FileWriter(NOM_F3)) {

			// Leemos un caracter de cada fichero.
			int c1 = f1.read();
			int c2 = f2.read();

			// Mientras que no lleguemos al final de alguno de los ficheros, seguimos
			// adelante.
			while (c1 != -1 && c2 != -1) {
				// Comparamos para poder ordenar. También comparamos con los excluidos.
				if (EXCLUIDOS.contains((char)c1)) {
					// Hemos leído un caracter de los que no necesitamos escribir, saltamos al
					// siguiente.
					c1 = f1.read();
				} else if (EXCLUIDOS.contains((char)c2)) {
					// Hemos leído un caracter de los que no necesitamos escribir, saltamos al
					// siguiente.
					c2 = f2.read();
				} else if (c1 < c2) {
					// c1 es menor. Lo escribimos y leemos el siguiente caracter de f1. Añadimos el
					// \n que hemos ignorado. Usamos un método de System que nos da el separador
					// adecuado para cada plataforma.
					f3.write(c1);
					f3.write(System.lineSeparator());
					c1 = f1.read();
				} else if (c2 < c1) {
					// c2 es menor. Lo escribimos y leemos el siguiente caracter de f2. Añadimos el
					// \n que hemos ignorado. Usamos un método de System que nos da el separador
					// adecuado para cada plataforma.
					f3.write(c2);
					f3.write(System.lineSeparator());
					c2 = f2.read();
				} else {
					// Son iguales. Escribimos los dos y leemos los dos siguientes caracteres. Uno
					// de cada fichero. Añadimos los \n que hemos ignorado. Usamos un método de
					// System que nos da el separador adecuado para cada plataforma.
					f3.write(c1);
					f3.write(System.lineSeparator());
					c1 = f1.read();
					f3.write(c2);
					f3.write(System.lineSeparator());
					c2 = f2.read();
				}
			}

			// Al terminar el bucle pueden pasar 3 cosas: que los dos ficheros se
			// hayan acabado a la vez, que se haya acabado f1 pero no f2, o que se haya
			// acabado f2 pero no f1. Si han acabado los dos no hay que hacer nada más. Si
			// se ha acabado f1 pero no f2 hay que volcar el resto de f2 en f3, y si se ha
			// acabado f2 pero no f1, hay que volcar el resto de f1 en f3.

			if (c1 == -1 && c2 != -1) {
				// Se ha acabado f1, volcamos f2. Lo hacemos con un do-while para empezar
				// escribiendo el caracter ya leído de f2
				do {
					f3.write(c2);
				} while ((c2 = f2.read()) != -1);
			}

			if (c1 != -1 && c2 == -1) {
				// Se ha acabado f2, volcamos f1. Lo hacemos con un do-while para empezar
				// escribiendo el caracter ya leído de f1
				do {
					f3.write(c1);
				} while ((c1 = f1.read()) != -1);
			}
		}
	}

	private static void mostrarFicheroCombinado() throws FileNotFoundException, IOException {
		try (FileReader fr = new FileReader(NOM_F3)) {
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
		}
	}

}
