package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo02casting;

public class Ave extends Animal {
	private int numHuevos;

	public Ave(String nombre, int numHuevos) {
		super(nombre);
		this.setNumHuevos(numHuevos);
	}

	public int getNumHuevos() {
		return numHuevos;
	}

	public void setNumHuevos(int numHuevos) {
		this.numHuevos = numHuevos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Soy un ave y me llamo ");
		sb.append(this.getNombre());
		sb.append(". Normalmente pongo ");
		sb.append(this.getNumHuevos());
		sb.append(" huevos.");
		return sb.toString();
	}
}
