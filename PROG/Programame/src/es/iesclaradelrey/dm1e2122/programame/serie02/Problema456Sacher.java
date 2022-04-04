package es.iesclaradelrey.dm1e2122.programame.serie02;

import java.util.Scanner;

public class P456Sacher {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());
		while (numCasos > 0) {
			int ancho = sc.nextInt();
			int alto = sc.nextInt();
			int necesarios = sc.nextInt();
			sc.nextLine();
			int tabletas = necesarios / (ancho * alto);
			if (necesarios % (ancho * alto) > 0)
				tabletas++;
			
			System.out.println(tabletas);

			numCasos--;
		}
	}
}
