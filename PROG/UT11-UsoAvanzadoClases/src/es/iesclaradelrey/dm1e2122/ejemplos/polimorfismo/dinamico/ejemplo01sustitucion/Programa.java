// Ejemplos de sustitución (asiganr a variables de superclase un objeto de subclase) y de casting

package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo01sustitucion;

public class Programa {
	public static void main(String[] args) {
		sinPolimorfismo();
		conPolimorfismo();
		asignacionDistintosTipos();
	}

	private static void sinPolimorfismo() {
		// Creamos un objeto de cada clase
		Ave a = new Ave("Juan");
		Pato p = new Pato("Pedro");
		Golondrina g = new Golondrina("Carlos");

		System.out.println("\n\nLlamamos a los métodos sin usar polimorfismo dinámico.");

		// Llamamos a sus métodos
		a.volar();
		p.volar();
		g.volar();
	
		a.emitirSonido();
		p.emitirSonido();
		g.emitirSonido();
		a.comer();
		p.comer();
		g.comer();
	}

	private static void conPolimorfismo() {
		// Creamos un objeto de cada clase, pero lo asignamos
		// a una variable de tipo superclase
		Ave a1 = new Ave("Alberto");
		Ave a2 = new Pato("María");
		Ave a3 = new Golondrina("Isabel");

		System.out.println("\n\nLlamamos a los métodos usando polimorfismo dinámico.");

		// Llamamos a sus métodos.
		a1.volar();
		a2.volar();
		a3.volar();
		a1.emitirSonido();
		a2.emitirSonido();
		a3.emitirSonido();
		a1.comer();
		a2.comer();
		a3.comer();
	}

	private static void asignacionDistintosTipos() {
		// Creamos una variable referencia a "Ave"
		// y le asignamos diferentes objetos de la
		// superclase y subclases

		System.out.println("\n\nAsignación de distintos tipos.");
		
		Ave a;

		a = new Ave("Juan");
		a.comer();

		a = new Pato("María");
		a.comer();

		a = new Golondrina("Marisa");
		a.comer();

	}
	
	@SuppressWarnings("unused")
	private static void asignacionErronea() {
		// Estas sentencias provocan error en compilación.
//		Pato p = new Ave("Juan");
//		Golondrina g = new Ave("");

	}
	
	@SuppressWarnings("unused")
	private static void tipoEstaticoDinamico() {
		// Tipo estático: Ave
		Ave a; 
		// Tipo estático y dinámico coinciden: Ave
		a = new Ave("Juan"); 
		// Tipo estático: Ave. Tipo Dinámico: Pato
		a = new Pato("María"); 
	}
}
