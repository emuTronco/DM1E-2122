package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01b;

public class Tarantula extends Aracnido implements Venenoso{
	private static final Peligrosidad PELIGROSIDAD = Peligrosidad.BAJA;
	private static final String NOMBRE_ESPECIE = "TARANTULA";
	private String nombre;

	public Tarantula(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Peligrosidad getPeligrosidad() {
		return PELIGROSIDAD;
	}

	@Override
	public void producirSeda(int distanciaCm) {
		System.out.println("Soy una " + NOMBRE_ESPECIE + ", me llamo " + nombre +", y estoy produciendo " + distanciaCm + " centímetros de seda.");
	}

}
