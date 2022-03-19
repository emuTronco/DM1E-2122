package es.iesclaradelrey.dm1e2122.problema01;

import java.util.Scanner;

public class Problema01 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int numCasos = Integer.parseInt(sc.nextLine());

		for (int numCaso = 0; numCaso < numCasos; numCaso++) {
			procesarCaso();
		}

	}

	private static void procesarCaso() {
		String linea = sc.nextLine();
		System.out.println(linea);
//		int posicion = 0;
//		for (String caracter: linea.split(" ")) {
//			if (posicion % 2 == 0) {
//				// Carta
//			}
//			else
//			{
//				// Palo
//				
//			}
//			
		/*
		 * 2 Q C A C 3 T Q T K T 2 D 4 D 5 D 7 D Q D 9 P Q P K P 6 D J P 7 P 6 P 5 P 4 P
		 * K C J C 9 C 8 C 4 C 2 C 10 T
		 * 
		 */

	}

}
