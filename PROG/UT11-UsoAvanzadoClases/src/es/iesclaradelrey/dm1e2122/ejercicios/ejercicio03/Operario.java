package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio03;

public class Operario extends Empleado{

	public Operario(String nombre) {
		super(nombre);
	}
	
	@Override
	public String toString() {
		return super.toString() + " -> Operario";
	}

}
