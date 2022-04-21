package es.iesclaradelrey.dm1e2122.examenrec2ev.ej1c;

public abstract class VehiculoAereo extends Vehiculo {

	private int altitudMaxima;

	public VehiculoAereo(String nombrePropietario, int altitudMaxima) {
		super(nombrePropietario);
		this.altitudMaxima = altitudMaxima;
	}

	public int getAltitudMaxima() {
		return this.altitudMaxima;
	}
}
