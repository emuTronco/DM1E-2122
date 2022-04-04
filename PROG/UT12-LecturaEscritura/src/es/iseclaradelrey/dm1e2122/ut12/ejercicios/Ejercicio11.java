package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

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

public class Ejercicio11 {

	private static final String NOM_FICHERO = "FicherosPrueba" + File.separator + "numerosEj11.bin";
	private static Random rnd = new Random();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("¿Cuántos números aleatorios quieres añadir al fichero? ");
		int numNumeros = Integer.parseInt(sc.nextLine());

		try (DataOutputStream fo = new DataOutputStream(new FileOutputStream(NOM_FICHERO, true))) {
			for (int i = 0; i < numNumeros; i++) {
				fo.writeInt(rnd.nextInt(101));
			}
		}
		mostrarContenidoFichero(NOM_FICHERO);
	}

	private static void mostrarContenidoFichero(String nombreFichero) throws IOException {

		System.out.println("Contenido del fichero:");
		try (DataInputStream is = new DataInputStream(new FileInputStream(NOM_FICHERO))) {
			boolean isEOF = false;
			while (!isEOF) {
				try {
					int entero = is.readInt();
					System.out.println(entero);
				} catch (EOFException e) {
					// Se ha llegado al final del fichero
					isEOF = true;
				}
			}
		}
	}

	private static void mostrarContenidoFichero2(String nombreFichero) {

		System.out.println("Contenido del fichero:");
		try (DataInputStream is = new DataInputStream(new FileInputStream(NOM_FICHERO))) {
			while (true) {
				int entero = is.readInt();
				System.out.println(entero);
			}
		} catch (EOFException e) {
		} catch (FileNotFoundException e1) {
			System.err.println("No se ha encontrado el fichero " + NOM_FICHERO);
			e1.printStackTrace();
		} catch (IOException e1) {
			System.err.println("Ha habido un error al usar fichero " + NOM_FICHERO);
			e1.printStackTrace();
		}
	}

}
