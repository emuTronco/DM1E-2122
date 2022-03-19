package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01b;

public class InsectoPalo extends Insecto {
	private static final String NOMBRE_ESPECIE = "INSECTO PALO";

	@Override
	public void ponerHuevos(int numeroHuevos) {
		System.out.println("Soy un " + NOMBRE_ESPECIE + " y estoy poniendo " + numeroHuevos + " huevos.");		
	}

}
