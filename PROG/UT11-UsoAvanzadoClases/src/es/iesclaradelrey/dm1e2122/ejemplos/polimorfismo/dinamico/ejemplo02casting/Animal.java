package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo02casting;

public class Animal {
	private String nombre;

	public Animal(String nombre) {
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
		StringBuilder sb = new StringBuilder();
		sb.append("Soy un mamífero y me llamo ");
		sb.append(this.getNombre());
		sb.append(".");
		return sb.toString();
	}
}
