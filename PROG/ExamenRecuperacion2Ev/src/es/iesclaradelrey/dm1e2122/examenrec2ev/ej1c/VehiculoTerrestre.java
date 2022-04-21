package es.iesclaradelrey.dm1e2122.examenrec2ev.ej1c;

public abstract class VehiculoTerrestre extends Vehiculo {
	
	private int numRuedas;

	public VehiculoTerrestre(String nombrePropietario, int numRuedas) {
		super(nombrePropietario);
		this.numRuedas = numRuedas;
	}

	public int getNumRuedas() {
		return this.numRuedas;
	}
}
