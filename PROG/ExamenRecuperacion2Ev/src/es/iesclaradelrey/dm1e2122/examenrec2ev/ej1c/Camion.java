package es.iesclaradelrey.dm1e2122.examenrec2ev.ej1c;

public class Camion extends VehiculoTerrestre implements Motorizado, Matriculable{

	private int cargaMaxima;
	private String matricula;
	private int potencia;
	
	public Camion(String nombrePropietario, int numRuedas, int cargaMaxima, String matricula) {
		super(nombrePropietario, numRuedas);
		this.cargaMaxima = cargaMaxima;
		this.matricula = matricula;
	}

	public int getCargaMaxima() {
		return cargaMaxima;
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
