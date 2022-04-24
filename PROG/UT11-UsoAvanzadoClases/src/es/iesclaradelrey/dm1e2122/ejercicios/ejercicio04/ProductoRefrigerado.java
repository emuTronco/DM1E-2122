package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio04;

public class ProductoRefrigerado extends Producto {
	private String codigoSupervisor;

	
	
	public ProductoRefrigerado(String fechaCaducidad, String lote, String codigoSupervisor) {
		super(fechaCaducidad, lote);
		this.setCodigoSupervisor(codigoSupervisor);
	}

	public String getCodigoSupervisor() {
		return codigoSupervisor;
	}

	public void setCodigoSupervisor(String codigoSupervisor) {
		this.codigoSupervisor = codigoSupervisor;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\nCódigo de organismo de supervisión: ");
		sb.append(this.codigoSupervisor);
		return sb.toString();
	}
}
