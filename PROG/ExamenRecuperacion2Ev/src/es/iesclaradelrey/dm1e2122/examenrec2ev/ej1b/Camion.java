package es.iesclaradelrey.dm1e2122.examenrec2ev.ej1b;

public class Camion extends VehiculoTerrestre {

	private int cargaMaxima;
	
	public Camion(String nombrePropietario, int numRuedas, int cargaMaxima) {
		super(nombrePropietario, numRuedas);
		this.cargaMaxima = cargaMaxima;
	}

	public int getCargaMaxima() {
		return cargaMaxima;
	}
	
}
