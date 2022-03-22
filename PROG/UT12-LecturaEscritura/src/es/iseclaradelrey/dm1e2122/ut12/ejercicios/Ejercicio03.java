package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio03 {

	private static final int NUM_CHAR_INDENT = 4;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce la ruta del directorio que quieres consultar: ");
		var ruta = sc.nextLine();

		File directorio = new File(ruta);

		if (!directorio.exists()) {
			System.out.println("No existe el directorio " + ruta);
		} else if (!directorio.isDirectory()) {
			System.out.println(ruta + "no es un directorio");
		} else {
			mostrarInfoDirectorio(directorio, 0);
		}
	}

	private static void mostrarInfoDirectorio(File directorio, int nivel) {
		var contenido = directorio.listFiles();
		for (File hijo : contenido) {
			String esDirectorio = hijo.isDirectory() ? "D" : "F";
			long tamanio = hijo.isDirectory() ? 0 : hijo.length();
			System.out.printf("%s%s %s %d\n", "-".repeat(nivel * NUM_CHAR_INDENT), esDirectorio, hijo.getName(),
					tamanio);
			if (hijo.isDirectory()) {
				mostrarInfoDirectorio(hijo, nivel + 1);
			}
		}
	}

}
