package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio03;

public class Tecnico extends Operario{
	public Tecnico(String nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return super.toString() + " -> Técnico";
	}

}
