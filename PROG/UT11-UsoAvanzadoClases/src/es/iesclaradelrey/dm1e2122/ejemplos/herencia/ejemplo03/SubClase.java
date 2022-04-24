package es.iesclaradelrey.dm1e2122.ejemplos.herencia.ejemplo03;

public class SubClase extends SuperClase {
	public SubClase() {
		super();
	}

	public SubClase(int numero) {
		super(numero);
	}
//	
//	public SubClase(String numero) {
//		int num = Integer.parseInt(numero);
//		this.setNumero(num);
//	}

	@Override
	public void escribeInformacion() {
		System.out.println("En el método 'escribeInfo' de SubClase.");
	}
	

	
}
