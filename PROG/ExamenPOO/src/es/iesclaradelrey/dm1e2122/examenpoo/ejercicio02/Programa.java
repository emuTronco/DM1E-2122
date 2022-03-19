package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio02;

public class Programa {

	public static void main(String[] args) {
		Persona p1 = new Persona("12345678A", "Jaime", "Martínez");
		Persona p2 = new Persona("12341228C", "Carlos", "Pérez", "Flores");
		Estudiante e1 = new Estudiante("7845484D", "Juan", "Santos", 7.5);
		Estudiante e2 = new Estudiante("87645648Z", "Javier", "López", "Salazar", 9.5);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(e1);
		System.out.println(e2);

		int comparacion = e1.compareTo(e2);
		if (comparacion == 0) {
			System.out.println("Tienen la misma nota.");
		} else if (comparacion < 0) {
			System.out.println("El primero tiene nota más baja.");
		} else {
			System.out.println("El segundo tiene nota más baja.");
		}

	}

} 
