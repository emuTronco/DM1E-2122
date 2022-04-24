// Ejemplos de casting, y de evaluación del tipo de una variable con instanceof / isInstance 

package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo02casting;

public class ProgramaCastingClases {

	public static void main(String[] args) {

		// Upcasting
		Ave paloma = new Ave("Paloma", 3);
		// No es necesario hacer animal01 = (Animal)paloma, 
		// pero si lo hacemos no pasa nada
		Animal animal01 = paloma; 
		System.out.println(animal01.toString());
		
		// Al hacer upcast, perdemos el acceso a los métodos de la sublclase.
		int numHuevos = paloma.getNumHuevos();
		// numHuevos = animal01.getNumHuevos(); // Esto no podemos hacerlo. Error al compilar.
		
		// Downcasting. 
		Ave gorrion = new Ave("Gorrión", 5);
		Mamifero perro = new Mamifero("Perro", 2);
		// Primero hacemos un par de upcasting.
		Animal animalA = gorrion; // Sigue siendo Ave (dinámico)
		Animal animalB = perro; // Sigue siendo Mamifero (dinámico)
		// Ahora hacemos el downcast
		Ave aveA = (Ave)animalA; // OK. Al ser tipo dinámico Ave.
		//Ave aveB = (Ave)animalB; // Error en ejecución. Al ser tipo dinámico Mamífero.
		
		// Comprobación de tipos. Operador instanceof.
		Animal animalX = new Ave("Gorrión", 5);
		Animal animalY = new Mamifero("Perro", 2);
		boolean animalXEsAve = animalA instanceof Ave; // true
		boolean animalYEsAve = animalB instanceof Ave; // false
		System.out.println(animalXEsAve);
		System.out.println(animalYEsAve);
		
		
		// Comprobación de tipos. usando isInstance.
		Animal animalP = new Ave("Gorrión", 5);
		Animal animalQ = new Mamifero("Perro", 2);
		// Comprobamos 
		boolean animalPEsAve = Ave.class.isInstance(animalP); // true
		boolean animalQEsAve = Ave.class.isInstance(animalQ); // false
		System.out.println(animalPEsAve);
		System.out.println(animalQEsAve);
		
	}

}
