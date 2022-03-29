package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos03basicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ejemplo11Scanner {

	public static void main(String[] args) {

		leerFicheroConScanner();
		procesarCadenaConScanner();
	}

	private static void leerFicheroConScanner() {
		// Ojo, el constructor de Scanner que recibe una cadena no es para ficheros.
		// Sirve para "parsear" la cadena y poder procesarla. Por eso usamos el
		// constructor que recibe un objeto File. Podríamos haber usado un constructor
		// que recibiera un Stream.

		// Abrimos el scanner en try-with-resources para que se cierren los recursos.
		try (Scanner sc = new Scanner(new File("FicherosPrueba/parrafo.txt"))) {
			// Mientras haya líneas que leer...
			while (sc.hasNextLine()) {
				// Leemos la línea
				String s = sc.nextLine();
				// La mostramos en la salida estándar
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero.");
			e.printStackTrace();
		}
	}

	private static void procesarCadenaConScanner() {

		// Cadena que vamos a procesar.
		String cadenaAProcesar = "1 4 23 67 25 16 97 18 9 51";

		// Vamos a ordenar los números usando una lista de enteros.
		List<Integer> lista = new ArrayList<>();
		
		// Usamos el constructor que nos permite procesar cadenas de texto.
		try (Scanner sc = new Scanner(cadenaAProcesar)) {
			while (sc.hasNextInt()) {
				lista.add(sc.nextInt());
			}
		}
		
		Collections.sort(lista);
		System.out.println(lista);

	}

}
