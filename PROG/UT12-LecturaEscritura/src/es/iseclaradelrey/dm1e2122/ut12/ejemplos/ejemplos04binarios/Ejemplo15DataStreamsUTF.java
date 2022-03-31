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
import java.util.Scanner;

public class Ejemplo15DataStreamsUTF {
	// Ejemplo que Pregunta al usuario una serie de líneas de texto y la salmacena
	// en un fichero, pero como datos binarios, junto a un número aleatorio que se
	// genera automáticamente. En el fichero se almacenan parejas de número y
	// cadena. Primero el número y luego la cadena.
	// Posteriormente se leen estos datos y se muestran en consola.

	private static final String PATH_PRUEBAS = "FicherosPrueba";
	private static final String FICHERO = PATH_PRUEBAS + File.separator + "paresNumeroCadena.dat";
	private static final Random RND = new Random();
	private static final int NUM_PAREJAS = 5;
	private static final int MAX_NUM = 100;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		generarFicheroPares();
		leerFicheroPares();
	}

	private static void generarFicheroPares() throws FileNotFoundException, IOException {
		System.out.printf("Generando %d parejas de número y texto y guardándolas en el fichero binario...\n",
				NUM_PAREJAS);
		
		System.out.println("Introduce " + NUM_PAREJAS + " líneas de texto."); 
		
		try(Scanner sc = new Scanner(System.in); DataOutputStream dos = new DataOutputStream(new FileOutputStream(FICHERO))){
			for(int i=0; i<NUM_PAREJAS; i++) {
				int numeroAleatorio = RND.nextInt(MAX_NUM);
				System.out.println("Introduce una frase");
				String frase = sc.nextLine();
				dos.writeInt(numeroAleatorio);
				dos.writeUTF(frase);
			}
		}
		System.out.println("Fichero generado.");
	}

	private static void leerFicheroPares() throws FileNotFoundException, IOException {
		System.out.println("Leyendo parejas guardadas en el fichero binario...");

		try (DataInputStream is = new DataInputStream(new FileInputStream(FICHERO))) {
			int numPareja = 1;
			boolean isEOF = false;
			while (!isEOF) {
				try {
					int entero = is.readInt();
					String frase = is.readUTF();
					System.out.printf("Pareja nº %d leída: %d, %s\n", numPareja, entero, frase);
					numPareja++;
				} catch (EOFException e) {
					// Se ha llegado al final del fichero
					isEOF = true;
				}
			}
		}
	}

}
