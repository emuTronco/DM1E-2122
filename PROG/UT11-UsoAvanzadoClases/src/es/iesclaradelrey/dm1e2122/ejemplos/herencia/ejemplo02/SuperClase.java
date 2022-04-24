package es.iesclaradelrey.dm1e2122.ejemplos.herencia.ejemplo02;

public class SuperClase {
	private int numero;
	
	public SuperClase() {
		this.setNumero(0);
	}
	
	public SuperClase(int numero) {
		this.setNumero(numero);
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void escribeInfo() {
		System.out.println("En el método 'escribeInfo' de SuperClase.");
	}
}
