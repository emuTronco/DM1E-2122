package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductoFresco extends Producto {

	private LocalDate fechaEnvasado;
	private String origen; 

	public ProductoFresco(String fechaCaducidad, String lote, String fechaEnvasado, String origen) {
		super(fechaCaducidad, lote);
		this.setFechaEnvasado(fechaEnvasado);
		this.setOrigen(origen);
	}

	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(String sFechaEnvasado) {
		this.fechaEnvasado = LocalDate.parse(sFechaEnvasado, DateTimeFormatter.ofPattern(FORMATO_FECHA));
	}
	
	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\nFecha de envasado: ");
		sb.append(this.fechaEnvasado);
		sb.append("\nOrigen: ");
		sb.append(this.origen);
		return sb.toString();
	}
}
