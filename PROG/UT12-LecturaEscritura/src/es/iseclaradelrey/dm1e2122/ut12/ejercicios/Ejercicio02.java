package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio02 {

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
			var contenido = directorio.listFiles();
			for (File file : contenido) {
				String esDirectorio = file.isDirectory() ? "D" : "F";
				long tamanio = file.isDirectory() ? 0 : file.length();
				System.out.printf("%s %s %d\n", esDirectorio, file.getName(), tamanio);
			}
		}
	}

}
