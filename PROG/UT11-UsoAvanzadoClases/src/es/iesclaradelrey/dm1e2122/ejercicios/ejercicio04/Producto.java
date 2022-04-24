package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Producto {
	
	protected final String FORMATO_FECHA = "dd/MM/yyyy"; 

	private LocalDate fechaCaducidad;
	private String lote;

	public Producto(String fechaCaducidad, String lote) {
		//Locale
		this.setFechaCaducidad(fechaCaducidad);
		this.setLote(lote);
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String sFechaCaducidad) {
		this.fechaCaducidad = LocalDate.parse(sFechaCaducidad, DateTimeFormatter.ofPattern(FORMATO_FECHA));
	}
	
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Fecha de caducidad: ");
		sb.append(fechaCaducidad);
		sb.append("\nLote: ");
		sb.append(lote);
		return sb.toString();
	}
	
}
