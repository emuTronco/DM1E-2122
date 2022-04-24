// Otro ejemplo de sobrescritura de métodos.

package es.iesclaradelrey.dm1e2122.ejemplos.herencia.ejemplo03;

public class Programa {
	public static void main(String[] args) {
		SuperClase c1 = new SuperClase();
		SubClase c2 = new SubClase(3);

		//c1.escribeInformacion();
		c2.escribeInformacion();
	}

}
