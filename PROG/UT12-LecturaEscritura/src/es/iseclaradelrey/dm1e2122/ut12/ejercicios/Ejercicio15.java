package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio15 {

	private static final String PATH_FICHERO = "FicherosPrueba" + File.separator + "fichero.obj";
	private static final String PATH_FICHERO_AUX = "FicherosPrueba" + File.separator + "ficheroAux.obj";

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		// Estas ctes podrian ir en un fichero externo
		final int MAXOPC = 6;

		int opcion;

		do {
			System.out.println("1.-Añadir numeros de tipo double al principio del fichero");
			System.out.println("2.-Añadir numero de tipo double al final del fichero.");
			System.out.println("3.-Mostrar el fichero creado.");
			System.out.println(
					"4.-Sustituir un numero indicado por el usuario por otro numero que también te indique el usuario.");
			System.out.println("5.-Ordena el fichero descendentemente.");
			System.out.println("6.-Salir del programa");
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1: {
				aniadirPpio(PATH_FICHERO, PATH_FICHERO_AUX, sc);
				break;
			}
			case 2: {
				aniadirFinal(PATH_FICHERO, sc);
				break;
			}
			case 3: {
				leerFichero(PATH_FICHERO);
				break;
			}
			case 4: {
				sustituirNumero(PATH_FICHERO, sc);
				break;
			}
			case 5: {
				ordenarFichero(PATH_FICHERO);
				break;
			}
			case 6: {
				System.out.println("Gracias por usar el programa....");
				break;
			}
			default: {
				System.out.println("Opcion incorrecta");
			}
			}
		} while (opcion != MAXOPC);

		sc.close();

	}

	public static void aniadirPpio(String nomFich, String nomFichA, Scanner sc) {
		File fichero = null, ficheroA = null;
		double numero;

		try (RandomAccessFile raf1 = new RandomAccessFile(nomFich, "rw");
				RandomAccessFile raf2 = new RandomAccessFile(nomFichA, "rw");) {

			System.out.println("Introduce un numero Double para aniadir al principio del fichero: ");
			numero = Double.parseDouble(sc.nextLine());
			aniadirNumeroAlPrincipio(raf1, raf2, numero);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			fichero = new File(nomFich);
			ficheroA = new File(nomFichA);
			if (fichero.delete())
				System.out.println("Se ha borrado y renombrado " + ficheroA.renameTo(fichero));
			else
				System.out.println("No se ha podido borrar");
		}
	}

	public static void aniadirNumeroAlPrincipio(RandomAccessFile raf1, RandomAccessFile raf2, double numero)
			throws Exception {
		double numeroLeido;

		raf1.seek(0); // Nos posicionamos al principio"ficheroAux.obj";

		raf2.writeDouble(numero); // Escribimos el numero
		try {
			numeroLeido = raf1.readDouble();
			System.out.println("numeroLeido y pasado al auxiliar (comentario en depuracion...): " + numeroLeido);
			raf2.writeDouble(numeroLeido);
		} catch (EOFException e) {// ?????
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void aniadirFinal(String nomFich, Scanner sc) {
		File fichero = new File(nomFich);

		System.out.println("Introduce un numero Double para añadir al final del fichero: ");
		double numero = Double.parseDouble(sc.nextLine());
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw");) {
			aniadirNumerosAlFinal(raf, numero);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void aniadirNumerosAlFinal(RandomAccessFile raf, double numero) throws Exception {
		raf.seek(raf.length());
		raf.writeDouble(numero);
	}

	public static void leerFichero(String nomFich) {
		RandomAccessFile raf = null;

		try {
			File fichero = new File(nomFich);
			if (fichero.exists()) {
				raf = new RandomAccessFile(fichero, "r");
				mostrarFichero(raf);
			} else
				System.out.println("El fichero no existe.");
		} catch (EOFException e) {
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void mostrarFichero(RandomAccessFile raf) throws Exception {
		double numero;

		raf.seek(0);
		while (true) {
			numero = raf.readDouble();
			System.out.println(numero);
		}
	}

	public static void sustituirNumero(String nomFich, Scanner teclado) {
		double sustituir, nuevo, numero;
		int i = 0;
		File fichero = new File(nomFich);

		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw");) {

			raf.seek(0);

			System.out.println("Introduce el valor que desea sustituir");
			sustituir = Double.parseDouble(teclado.nextLine());

			System.out.println("Introduce el nuevo valor");
			nuevo = Double.parseDouble(teclado.nextLine());

			while (true) {
				numero = raf.readDouble();
				if (numero == sustituir) {
					System.out.println("Encontrado en la posicion " + i);
					// raf.seek(i * 8); // En la v8 de Java podemos hacer:
					raf.seek(i * Double.BYTES);
					raf.writeDouble(nuevo);
				}
				i++;
			}
		} catch (EOFException e) {
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void ordenarFichero(String nomFich) {
		RandomAccessFile raf = null;
		Double numeroLeido;
		ArrayList<Double> numeros = new ArrayList<Double>();

		// Guardo el contenido del fichero en un arraylist
		// y lo ordeno, volviendo a escribir en el fichero desde el principio.

		try {
			raf = new RandomAccessFile(nomFich, "rw");
			numeroLeido = raf.readDouble();
			System.out.println("numeroLeido: " + numeroLeido);
			numeros.add(numeroLeido);
		} catch (EOFException e) {
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			numeros.sort(Collections.reverseOrder());

			try {
				raf.seek(0);
				// Copiamos los números ya ordenados
				Iterator<Double> it = numeros.iterator();
				while (it.hasNext())
					raf.writeDouble(it.next());

				if (raf != null)
					raf.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
