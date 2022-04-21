package es.iesclaradelrey.dm1e2122.examenrec2ev.ej1b;

public class Ultraligero extends VehiculoAereo {

	private float envergadura;
	
	public Ultraligero(String nombrePropietario, int altitudMaxima, float envergadura) {
		super(nombrePropietario, altitudMaxima);
		this.envergadura = envergadura;
	}

	public float getEnvergadura() {
		return envergadura;
	}

}
