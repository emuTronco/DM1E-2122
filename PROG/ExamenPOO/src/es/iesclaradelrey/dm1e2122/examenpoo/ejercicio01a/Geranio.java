package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01a;

public class Geranio extends Vegetal {

	private static final String NOMBRE_ESPECIE = "GERANIO";

	@Override
	public void fotosintesis(int intensidadLuz) {

		System.out.println("Soy un " + NOMBRE_ESPECIE + " y estoy procesando " + intensidadLuz + " lux.");

	}

}
