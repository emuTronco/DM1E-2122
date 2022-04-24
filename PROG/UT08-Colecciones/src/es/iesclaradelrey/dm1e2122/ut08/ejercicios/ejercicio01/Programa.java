package es.iesclaradelrey.dm1e2122.ut08.ejercicios.ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();
		
		leerValoresUsuario(numeros);
		
		System.out.printf("Se han cargado %d valores.\n", numeros.size());
		
		System.out.printf("La media es %f.\n", calcularMedia(numeros));
		
		Integer max = obtenerMaximo(numeros);
		System.out.printf("El máximo es %s.\n", max == null ? "(no se han cargado numeros)" : max );
		// Alternativa si se usa el método que no devuelve nulos.
		//System.out.printf("El máximo es %s.\n", max == Integer.MIN_VALUE ? "(no se han cargado numeros)" : max );
		
		Integer min = obtenerMinimo(numeros);
		System.out.printf("El mínimo es %s.\n", min == null ? "(no se han cargado numeros)" : min );
		// Alternativa si se usa el método que no devuelve nulos.
		//System.out.printf("El mínimo es %s.\n", max == Integer.MAX_VALUE ? "(no se han cargado numeros)" : min );
	}

	private static double calcularMedia(List<Integer> numeros) {
		int suma = 0;
		for (Integer num : numeros) {
			suma += num;
		}
		return (double)suma / numeros.size();
	}

	private static Integer obtenerMaximo(List<Integer> numeros) {
		Integer maximo = null;
		for (Integer num : numeros) {
			if(maximo == null || num > maximo)
				maximo = num;
		}
		return maximo;
	}

	// Alternativa en la que no se devuelve null. 
	@SuppressWarnings("unused")
	private static int obtenerMaximo2(List<Integer> numeros) {
		int maximo = Integer.MIN_VALUE;
		for (Integer num : numeros) {
			if(num > maximo)
				maximo = num;
		}
		return maximo;
	}

	private static Integer obtenerMinimo(List<Integer> numeros) {
		Integer minimo = null;
		for (Integer num : numeros) {
			if(minimo == null || num < minimo)
				minimo = num;
		}
		return minimo;
	}
	
	// Alternativa en la que no se devuelve null. 
	@SuppressWarnings("unused")
	private static int obtenerMinimo2(List<Integer> numeros) {
		int minimo = Integer.MAX_VALUE;
		for (Integer num : numeros) {
			if(num < minimo)
				minimo = num;
		}
		return minimo;
	}
	
	private static void leerValoresUsuario(List<Integer> numeros) {
		int numero;
		do {
			System.out.print("Introduce un número: ");
			numero = Integer.parseInt(sc.nextLine());
			if (numero != -9999)
				numeros.add(numero);
		} while (numero != -9999);
	}

}
