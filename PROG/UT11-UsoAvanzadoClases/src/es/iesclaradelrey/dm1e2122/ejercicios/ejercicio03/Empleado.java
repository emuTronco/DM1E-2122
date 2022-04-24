package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio03;

public class Empleado extends Object {
	private String nombre;

	public Empleado() {
		setNombre("desconocido");
	}
	
	public Empleado(String nombre) {
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre;
	}
}
