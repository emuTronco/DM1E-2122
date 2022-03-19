package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01a;

public class Perro extends Animal implements Mamifero {
	private static final String NOMBRE_ESPECIE = "PERRO";

	private String nombre;

	public Perro(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void comer(String comida) {
		System.out.println("Soy un " + NOMBRE_ESPECIE + ", me llamo " + nombre + ", y estoy comiendo " + comida + ".");
	}

	@Override
	public void darALuz(int numeroCrias) {
		System.out.println(
				"Soy un " + NOMBRE_ESPECIE + ", me llamo " + nombre + ", y he dado a luz " + numeroCrias + " crías.");
	}

	@Override
	public void amamantar(int numeroCrias) {
		System.out.println("Soy un " + NOMBRE_ESPECIE + ", me llamo " + nombre + ", y estoy amamantando a " + numeroCrias
				+ " crías.");
	}
}
