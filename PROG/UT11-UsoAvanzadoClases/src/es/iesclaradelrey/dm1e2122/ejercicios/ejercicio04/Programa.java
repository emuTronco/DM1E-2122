package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio04;

public class Programa {

	public static void main(String[] args) {
		Producto p = new Producto("30/12/2022", "AAA34343");
		System.out.println(p);
		Producto p2 = new ProductoFresco("15/02/2022", "DRRE41546", "15/01/2022", "Madrid");
		System.out.println(p2);
		Producto p3 = new ProductoRefrigerado("22/03/2022", "33FR53ES", "SUP3234EE");
		System.out.println(p3);
		Producto p4 = new ProductoCongelado("22/03/2022", "33FR53ES", -15);
		System.out.println(p4);
		}

}
