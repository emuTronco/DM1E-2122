package es.iesclaradelrey.dm1e2122.examenrec2ev.ej1c;

public class Planeador extends VehiculoAereo implements Matriculable {

	private String matricula;

	public Planeador(String nombrePropietario, int altitudMaxima, String matricula) {
		super(nombrePropietario, altitudMaxima);
		this.matricula = matricula;
	}

	@Override
	public String getMatricula() {
		return this.matricula;
	}

}
