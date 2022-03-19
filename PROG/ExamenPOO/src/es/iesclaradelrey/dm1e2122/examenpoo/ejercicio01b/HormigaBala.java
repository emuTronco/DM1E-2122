package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01b;

public class HormigaBala extends Insecto implements Venenoso {
	private static final String NOMBRE_ESPECIE = "HORMIGA BALA";
	private static final Peligrosidad PELIGROSIDAD = Peligrosidad.MEDIA;

	@Override
	public Peligrosidad getPeligrosidad() {
		return PELIGROSIDAD;
	}

	@Override
	public void ponerHuevos(int numeroHuevos) {
		System.out.println("Soy una " + NOMBRE_ESPECIE + " y estoy poniendo " + numeroHuevos + " huevos.");		
	}

}
