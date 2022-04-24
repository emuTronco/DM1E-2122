package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo01sustitucion;

public class Ave {
	private String nombre;

	public Ave(String nombre) {
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void comer() {
		System.out.println(this.nombre + " está comiendo lo que sea que coma");
	}

	public void emitirSonido() {
		System.out.println(this.nombre + " está emitiendo sonidos");
	}

	public void volar() {
		System.out.println(this.nombre + " está volando");
	}
}


