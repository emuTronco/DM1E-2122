package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo01sustitucion;

public class Pato extends Ave {
	public Pato(String nombre)	{
		super(nombre);
	}
	
	@Override
	public void comer() {
		System.out.println(this.getNombre() + " está comiendo pescado");
	}
	
	@Override
	public void emitirSonido() {
		System.out.println(this.getNombre() + " dice 'cuack'");
	}
	
	public void nadar() {
		System.out.println(this.getNombre() + " está nadando");
	}
}

