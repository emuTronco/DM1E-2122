package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio03;

public class Oficial extends Operario {
	public Oficial(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + " -> Oficial";
	}


}
