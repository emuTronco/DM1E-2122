package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01a;

public abstract class Animal extends Organismo {

	private static final TipoOrganismo TIPO_ORGANISMO = TipoOrganismo.PLURICELULAR;

	public Animal() {
		super(TIPO_ORGANISMO);
	}
	
	public abstract void comer(String comida);

}
