package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio13 {

	private static String PATH_FICHERO = "FicherosPrueba" + File.separator + "datosbeca.bin";
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String nombreApellidos = pideDatosString("Nombre y apellidos: ");
		char sexo = pideDatosChar("Sexo: ");
		int edad = pideDatosInt("Edad: ");
		int numSuspensos = pideDatosInt("Nº de suspensos del curso anterior: ");
		boolean residenciaFamiliar = pideDatosBoolean("Residencia familiar: ");
		double ingresos = pideDatosDouble("Ingresos familiares anuales: ");
		
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(PATH_FICHERO, true))) {
			dos.writeUTF(nombreApellidos);
			dos.writeChar(sexo);
			dos.writeInt(edad);
			dos.writeInt(numSuspensos);
			dos.writeBoolean(residenciaFamiliar);
			dos.writeDouble(ingresos);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
		} catch (IOException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
			e.printStackTrace();
		}
	}

	private static String pideDatosString(String pregunta) {
		System.out.print(pregunta);
		return sc.nextLine();
	}

	private static char pideDatosChar(String pregunta) {
		System.out.print(pregunta);
		return sc.nextLine().charAt(0);
	}

	private static int pideDatosInt(String pregunta) {
		System.out.print(pregunta);
		return Integer.parseInt(sc.nextLine());
	}

	private static double pideDatosDouble(String pregunta) {
		System.out.print(pregunta);
		return Double.parseDouble(sc.nextLine());
	}

	private static boolean pideDatosBoolean(String pregunta) {
		System.out.print(pregunta);
		return Boolean.parseBoolean(sc.nextLine());
	}

}
