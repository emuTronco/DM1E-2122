package es.iesclaradelrey.dm1e2122.examenrec2ev.ej1a;

public abstract class Vehiculo {
	private String nombrePropietario;

	public Vehiculo(String nombrePropietario) {
		super();
		this.nombrePropietario = nombrePropietario;
	}

	public String getNombrePropietario() {
		return this.nombrePropietario;
	}
}
