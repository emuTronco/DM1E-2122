package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo02casting;

public class Mamifero extends Animal {
	private int numMesesGestacion;

	public Mamifero(String nombre, int numMesesGestacion) {
		super(nombre);
		this.setNumMesesGestacion(numMesesGestacion);
	}

	public int getNumMesesGestacion() {
		return numMesesGestacion;
	}

	public void setNumMesesGestacion(int numMesesGestacion) {
		this.numMesesGestacion = numMesesGestacion;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Soy un mamífero y me llamo ");
		sb.append(this.getNombre());
		sb.append(". Mi periodo de gestación es de ");
		sb.append(this.getNumMesesGestacion());
		sb.append(" meses.");
		return sb.toString();
	}
}
