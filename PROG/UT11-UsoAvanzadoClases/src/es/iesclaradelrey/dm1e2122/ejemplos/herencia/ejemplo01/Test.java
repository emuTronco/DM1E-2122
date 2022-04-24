package es.iesclaradelrey.dm1e2122.ejemplos.herencia.ejemplo01;

public class Test {
	public void diAlgo() {
		System.out.println("En el método añadido");
	}
	
	public String toString() {
		return "Esto es un objeto de tipo TEST, y antes devolvía: " + super.toString();
	}
}
