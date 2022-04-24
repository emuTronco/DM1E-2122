package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo01sustitucion;

public class Golondrina extends Ave {
	public Golondrina(String nombre) {
		super(nombre);
	}

	@Override
	public void comer() {
		System.out.println(this.getNombre() + " está comiendo insectos");
	}
	
	@Override
	public void emitirSonido() {
		System.out.println( this.getNombre() + " dice 'chip'");
	}
}
