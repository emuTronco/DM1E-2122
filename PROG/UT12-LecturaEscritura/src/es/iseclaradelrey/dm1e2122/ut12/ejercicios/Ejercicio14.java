package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio14 {

	private static String PATH_FICHERO = "FicherosPrueba" + File.separator + "datosbeca.bin";
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String nombreApellidos;
		char sexo;
		int edad;
		int numSuspensos;
		boolean residenciaFamiliar;
		double ingresos;

		try (DataInputStream dis = new DataInputStream(new FileInputStream(PATH_FICHERO))) {
			boolean eof = false;
			while (!eof) {
				try {
					nombreApellidos = dis.readUTF();
					sexo = dis.readChar();
					edad = dis.readInt();
					numSuspensos = dis.readInt();
					residenciaFamiliar = dis.readBoolean();
					ingresos = dis.readDouble();

					System.out.printf("%s - %f\n", nombreApellidos, calculaCuantia(ingresos, edad, numSuspensos, residenciaFamiliar));

				} catch (EOFException e) {
					eof = true;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
		} catch (IOException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO);
			e.printStackTrace();
		}
	}

	private static double calculaCuantia(double ingresos, int edad, int numSuspensos, boolean residenciaFamiliar) {
		double total = 0;
		switch (numSuspensos) {
		case 0:
			total += 500;
			break;
		case 1:
			total += 200;
			break;
		}
		if (numSuspensos < 2) {
			if (ingresos < 1200) {
				total += 500;
			}
			if (edad < 23) {
				total += 200;
			}
			if (!residenciaFamiliar) {
				total += 1000;
			}
		}
		return total;
	}

}
