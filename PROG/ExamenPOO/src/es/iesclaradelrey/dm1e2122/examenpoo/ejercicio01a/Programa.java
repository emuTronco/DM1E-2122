package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01a;

public class Programa {

	public static void main(String[] args) {
		
		Organismo[] organismos = new Organismo[6];

		organismos[0] = new Cocodrilo();
		organismos[1] = new Geranio();
		organismos[2] = new Perro("Lassie");
		organismos[3] = new Cocodrilo();
		organismos[4] = new Geranio();
		organismos[5] = new Perro("Laika");

		for (int i = 0; i < organismos.length; i++) {
			System.out.println("Organismo " + (i + 1) + ": " + organismos[i].getTipoOrganismo());
		}

		// Recorrer el array de organismos con un bucle for-each y:
		// - si es Vegetal, llamar al método fotosíntesis con valor de paramétro 10
		// - si es Animal, llamar al método comer con valor de paraḿetro "comida"
		// - si es Animal Mamífero llamar al método "amamanatar" con valor de parámetro "5".
		// - si el Animal Reptil llamar al método "reptar" con valor de parámetro "7".

		for (Organismo organismo : organismos) {
			if (organismo instanceof Vegetal) {
				((Vegetal) organismo).fotosintesis(10);	
			}
			if (organismo instanceof Animal) {
				((Animal) organismo).comer("comida");
			}
			if (organismo instanceof Mamifero) {
				((Mamifero) organismo).amamantar(5);
			}
			if (organismo instanceof Reptil) {
				((Reptil) organismo).reptar(7);
			}
			
			
			
			
			
		}

	}

}
