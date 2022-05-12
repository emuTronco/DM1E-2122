package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio12 {

	private static final String NOM_FICHERO = "FicherosPrueba" + File.separator + "datosEj12.bin";
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.out.println("¿Matrícula? ");
//		String matricula = sc.nextLine();
//		System.out.println("¿Marca? ");
//		String marca = sc.nextLine();
//		System.out.println("¿Modelo? ");
//		String modelo = sc.nextLine();
//		System.out.println("¿Capacidad del depósito? ");
//		Double capacidad = Double.parseDouble(sc.nextLine());
//		
//		try (DataOutputStream fo = new DataOutputStream(new FileOutputStream(NOM_FICHERO, true))) {
//			fo.writeUTF(matricula);
//			fo.writeUTF(marca);
//			fo.writeUTF(modelo);
//			fo.writeDouble(capacidad);
//		}
		mostrarContenidoFichero(NOM_FICHERO);
	}
	
	private static void mostrarContenidoFichero (String nombreFichero) throws IOException {
		
		System.out.println("Contenido del fichero:");
		try (DataInputStream is = new DataInputStream(new FileInputStream(NOM_FICHERO))) {
			boolean isEOF = false;
			while (!isEOF) {
				try {
					String matricula = is.readUTF();
					String marca = is.readUTF();
					String modelo = is.readUTF();
					Double capacidad = is.readDouble();
					
					System.out.printf("%s - %s - %s - %f\n", matricula, marca, modelo, capacidad);

				} catch (EOFException e) {
					// Se ha llegado al final del fichero
					isEOF = true;
				}
			}
		}
		
		
	}
}
