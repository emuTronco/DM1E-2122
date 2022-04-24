package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio0102;

import java.util.Scanner;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// se leen las personas y se introducen en el array
		Persona[] personas = leerPersonas(sc);

		if (numeroDePersonas(personas) > 0) {

			// se muestran todas las personas introducidas
			System.out.println("\nPersonas introducidas: ");
			mostrar(personas);

			// se muestra la persona de mayor edad
			System.out.println("\nPersona de mayor edad: ");
			System.out.println(personaMayorEdad(personas));

			// se muestran todas las personas que viven en Elche
			System.out.println("\nNúmero de personas que viven en Elche: " + cuantasPersonasVivenEn("Elche", personas));

			// se muestra el número de personas mayores de edad
			System.out.println("\nNúmero de personas mayores de edad : " + personasMayoresDeEdad(personas));
		}
		sc.close();
	}

	private static Persona[] leerPersonas(Scanner sc) {
		// Preguntamos cuantas personas se van a crear.
		System.out.print("¿Cuantas personas va a crear? ");
		int numPersonas = Integer.parseInt(sc.nextLine());

		// Creamos un array del tamaño adecuado.
		Persona[] personas = new Persona[numPersonas];

		// Preguntamos al usuario los datos de cada persona, y las guardamos en el
		// array.
		for (int i = 0; i < numPersonas; i++) {
			personas[i] = leerUnaPersona(sc, i + 1);
		}

		return personas;
	}

	private static Persona leerUnaPersona(Scanner sc, int numPersona) {
		System.out.println("\n\nIntroduzca los datos para la persona nº " + numPersona);
		System.out.print("Nombre completo: ");
		String nombre = sc.nextLine();
		System.out.print("Dirección: ");
		String direccion = sc.nextLine();
		System.out.print("Código postal: ");
		String codigoPostal = sc.nextLine();
		System.out.print("Ciudad: ");
		String ciudad = sc.nextLine();
		System.out.println("Fecha de nacimiento (día, mes y año)...");
		System.out.print("Día: ");
		int diaNac = Integer.parseInt(sc.nextLine());
		System.out.print("Mes: ");
		int mesNac = Integer.parseInt(sc.nextLine());
		System.out.print("Año: ");
		int anioNac = Integer.parseInt(sc.nextLine());

		return new Persona(nombre, direccion, codigoPostal, ciudad, diaNac, mesNac, anioNac);
	}

	private static int numeroDePersonas(Persona[] personas) {
		// Podría devolverse personas.length, pero también podemos hacerlo de forma que sólo cuente los no-nulos en el array.
		int cuenta = 0;
		for (Persona p : personas) {
			if (p != null)
				cuenta++;
		}
		return cuenta;
	
	}

	private static void mostrar(Persona[] personas) {
		for (Persona p : personas) {
			System.out.println(p);
		}
	}

	private static Persona personaMayorEdad(Persona[] personas) {
		Persona personaMayor = null;
		for (Persona p : personas) {
			if (p != null) {
				if (personaMayor == null) {
					personaMayor = p;
				} else {
					if (!p.getFechaNacimiento().esMayorQue(personaMayor.getFechaNacimiento())) {
						personaMayor = p;
					}
				}
			}
		}
		return personaMayor;
	}

	private static int cuantasPersonasVivenEn(String donde, Persona[] personas) {
		int contador = 0;
		for (Persona p : personas) {
			if (p != null && p.getCiudad().equalsIgnoreCase(donde))
				contador++;
		}
		return contador;
	}

	private static int personasMayoresDeEdad(Persona[] personas) {
		int contador = 0;
		for (Persona p : personas) {
			if (p != null && p.esMayorDeEdad())
				contador++;
		}
		return contador;
	}
}
