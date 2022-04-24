// Ejemplo de relación de dependencia.
// Nuestra clase "EjemploDependencia01" depende de muchas clases, 
// entre otras de Scanner, de InputStream, PrintStream, o Math. 
package es.iesclaradelrey.dm1e2122.ejemplos.dependencia;

import java.util.Scanner;

public class EjemploDependencia01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("¿Cuántos números aleatorios quieres generar? ");
		int cantidadNumeros = Integer.parseInt(sc.nextLine());
		for(int i=0; i<cantidadNumeros; i++) {
			System.out.println(i + " - " + Math.random());
		}
		sc.close();
	}
}
