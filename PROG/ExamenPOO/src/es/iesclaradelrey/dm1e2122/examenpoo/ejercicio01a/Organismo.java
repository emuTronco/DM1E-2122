package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01a;

public abstract class Organismo {
	private TipoOrganismo tipoOrganismo;

	public Organismo(TipoOrganismo tipoOrganismo) {
		this.tipoOrganismo = tipoOrganismo;
	}

	public TipoOrganismo getTipoOrganismo() {
		return tipoOrganismo;
	}
	
}
