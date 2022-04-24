package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio03;

public class Directivo extends Empleado{

	public Directivo(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + " -> Directivo";
	}

}
