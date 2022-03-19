package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01b;

public class Programa {

	public static void main(String[] args) {
		Artropodo[] artropodos = new Artropodo[6];

		artropodos[0] = new HormigaBala();
		artropodos[1] = new InsectoPalo();
		artropodos[2] = new Tarantula("Ungoliant");
		artropodos[3] = new HormigaBala();
		artropodos[4] = new InsectoPalo();
		artropodos[5] = new Tarantula("Shelob");

		for (int i = 0; i < artropodos.length; i++) {
			System.out.println("Artrópodo " + (i + 1) + " - Número de patas: " + artropodos[i].getNumeroPatas());
		}

		// Recorrer el array de organismos con un bucle for-each y:
		// - si es Insecto, llamar al método ponerHuevos 
		//   con valor de paramétro 100
		// - si es Aracnido, llamar al método producirSeda 
		//   con valor de paraḿetro 50
		// - si es Venenoso, usar el método getPeligrosidad y sysout
		//   para indicar que es peligroso y nivel de peligrosidad

		for (Artropodo artropodo : artropodos) {
			if (artropodo instanceof Insecto) {
				((Insecto) artropodo).ponerHuevos(100);
			}
			if (artropodo instanceof Aracnido) {
				((Aracnido) artropodo).producirSeda(50);
			}
			if (artropodo instanceof Venenoso) {
				System.out.println("Venenoso. Peligrosidad: " + ((Venenoso)artropodo).getPeligrosidad());
			}
		}
	}

}
