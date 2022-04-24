package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio04;

public class ProductoCongelado extends Producto {

	private int temperaturaCongelacion;

	
	
	public ProductoCongelado(String fechaCaducidad, String lote, int temperaturaCongelacion) {
		super(fechaCaducidad, lote);
		this.setTemperaturaCongelacion(temperaturaCongelacion);
	}

	public int getTemperaturaCongelacion() {
		return temperaturaCongelacion;
	}

	public void setTemperaturaCongelacion(int temperaturaCongelacion) {
		this.temperaturaCongelacion = temperaturaCongelacion;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\nTemperatura de congelación recomendada: ");
		sb.append(this.temperaturaCongelacion);
		return sb.toString();
	}


}
