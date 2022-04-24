package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.estatico;

public class ClaseConSobrecargas {
	public void metodoSobrecargado() {
		System.out.println("En versión sin parámetros de 'metodoSobrecargado'.");
	}

	public void metodoSobrecargado(int i) {
		System.out.println("En versión con parámetro int de 'metodoSobrecargado'.");
		System.out.println("Valor del parámetro: " + i);
	}

	public void metodoSobrecargado(String s) {
		System.out.println("En versión con parámetro String de 'metodoSobrecargado'.");
		System.out.println("Valor del parámetro: " + s);
	}
}


