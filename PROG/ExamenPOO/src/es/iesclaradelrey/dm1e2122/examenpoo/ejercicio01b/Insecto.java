package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01b;

public abstract class Insecto extends Artropodo {
	private static final int NUMERO_PATAS = 6;

	public Insecto() {
		super(NUMERO_PATAS);
	}
	
	public abstract void ponerHuevos(int numeroHuevos);
	
}
