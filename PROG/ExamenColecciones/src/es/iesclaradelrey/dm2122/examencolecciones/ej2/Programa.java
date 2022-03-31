package es.iesclaradelrey.dm2122.examencolecciones.ej2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Programa {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<>();

		pedirNumerosUsuario(numeros);

		Map<Integer, Integer> cuenta = new TreeMap<>(Comparator.reverseOrder());
		
		for (Integer num : numeros) {
			int longitudNumero = num.toString().length();
			var cuantos = cuenta.get(longitudNumero);
			if (cuantos == null) cuantos = 0;
			cuantos++;
			cuenta.put(longitudNumero, cuantos);
		}
		
		for (Map.Entry<Integer, Integer> entry : cuenta.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " caracteres: " + val);
		}
	}

	private static void pedirNumerosUsuario(List<Integer> numeros) {
		int num = 0;
		do {
			System.out.print("Introduzca un número mayor o igual que cero. Introduzca un número negativo para terminar. ");
			try {
				num = Integer.parseInt(sc.nextLine());
				if (num >= 0)
					numeros.add(num);
			} catch (NumberFormatException e) {
				System.out.println("El valor introducido no es un número válido.");
			} catch (Exception e) {
				System.out.println("El valor introducido no es un número válido.");
			}
		} while (num >= 0);
	}

}
