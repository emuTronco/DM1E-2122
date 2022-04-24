package es.iesclaradelrey.dm1e2122.ejemplos.herencia.ejemplo02;

public class SubClase extends SuperClase {
	public SubClase() {
		super();
	}

	public SubClase(int numero) {
		super(numero);
	}
	
	public SubClase(String numero) {
		int num = Integer.parseInt(numero);
		this.setNumero(num);
	}

	@Override
	public void escribeInfo() {
		System.out.println("En el método 'escribeInfo' de SubClase.");
	}
}
