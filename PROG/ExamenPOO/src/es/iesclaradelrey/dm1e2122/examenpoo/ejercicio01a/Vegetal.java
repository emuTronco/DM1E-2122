package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01a;

public abstract class Vegetal extends Organismo{

	private static final TipoOrganismo TIPO_ORGANISMO = TipoOrganismo.PLURICELULAR;

	public Vegetal() {
		super(TIPO_ORGANISMO);
	}

	public abstract void fotosintesis(int intensidadLuz);
}
