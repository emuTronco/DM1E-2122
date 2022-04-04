package es.iesclaradelrey.dm1e2122.programame.serie02;

import java.util.Scanner;

public class Problema614TrenCorto {

	// Cada caso de prueba comienza con dos números, 1 ≤ T ≤ E ≤ 200.000 indicando,
	// respectivamente, la longitud del tren y del andén.
	// A continuación aparecen, en otra línea, E números (entre 1 y 1.000) indicando
	// cuántos pasajeros hay en cada posición.
	// La entrada termina con dos ceros.

	// Por cada caso de prueba el programa escribirá la menor longitud total
	// acumulada que tendrán que recorrer los pasajeros en el andén, asumiendo que
	// el tren para en el mejor sitio posible.
	// Si un pasajero está situado en una zona del andén en la que para el tren, se
	// asume que no deberá desplazarse hasta llegar a una puerta.
	
	// Ejemplo de entrada
	/*
2 4
1 1 1 1
2 5
1 1 1 1 1
3 6
10 5 0 0 10 10
0 0

*/

	private static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {

		int tren = SC.nextInt();
		int anden = SC.nextInt();
		SC.nextLine();
		
		while (tren != 0 ) {
			// Leer array de pasajeros
			int[] pasajeros = new int[anden];
			for (int i=0; i<anden;i++) {
				pasajeros[i] = SC.nextInt();
			}
			SC.nextLine();

			// Variables para almacenar resultado y mínimo.
			int minimo = Integer.MAX_VALUE;
			int parcial;
			for (int posicionCabecera = 0; posicionCabecera <= anden - tren; posicionCabecera++) {
				parcial = calcularDesplazamientos(pasajeros, posicionCabecera, tren, anden, minimo);
				if (parcial < minimo) {
					minimo = parcial;
				}
			}
			System.out.println(minimo);
			
			// Volvemos a leer tren 
			tren = SC.nextInt();
			anden = SC.nextInt();
			SC.nextLine();
		}
	}

	private static int calcularDesplazamientos(int[] pasajeros, int posicionCabecera, int longitudTren,
			int longitudAnden, int minimoActual) {
		int acumulado = 0;
		// Acumular personas en anden desde inicio hasta cabecera
		for (int posAnden = 0; (posAnden < posicionCabecera) && (acumulado < minimoActual); posAnden++) {
			acumulado += pasajeros[posAnden]*(posicionCabecera-posAnden);
		}
		int finTren = posicionCabecera+longitudTren-1;
		// Acumular personas en anden desde cola hasta final
		for (int posAnden = finTren+1; (posAnden < longitudAnden) && (acumulado < minimoActual); posAnden++) {
			acumulado += pasajeros[posAnden]*(posAnden-finTren);
		}
		return acumulado;
	}
}
