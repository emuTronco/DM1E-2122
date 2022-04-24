// Ejemplo de sobreescritura (override) de métodos.

package es.iesclaradelrey.dm1e2122.ejemplos.herencia.ejemplo02;

public class Programa {
	public static void main(String[] args) {
		SuperClase c1 = new SuperClase();
		SubClase c2 = new SubClase();

		c1.escribeInfo();
		c2.escribeInfo();
	}

}
