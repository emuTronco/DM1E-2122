package es.iesclaradelrey.dm1e2122.examenrec2ev.ej1c;

public class Ultraligero extends VehiculoAereo implements Motorizado, Matriculable {

	private float envergadura;
	private String matricula;
	private int potencia;

	public Ultraligero(String nombrePropietario, int altitudMaxima, float envergadura, String matricula, int potencia) {
		super(nombrePropietario, altitudMaxima);
		this.envergadura = envergadura;
		this.matricula = matricula;
		this.potencia = potencia;
	}

	public float getEnvergadura() {
		return envergadura;
	}

	@Override
	public String getMatricula() {
		return this.matricula;
	}

	@Override
	public int getPotencia() {
		return this.potencia;
	}

}
