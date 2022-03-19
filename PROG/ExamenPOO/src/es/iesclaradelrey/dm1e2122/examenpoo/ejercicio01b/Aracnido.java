package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01b;

public abstract class Aracnido extends Artropodo {

	private static final int NUMERO_PATAS = 8;

	public Aracnido() {
		super(NUMERO_PATAS);
	}

	public abstract void producirSeda(int distanciaCm);

}
