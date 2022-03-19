package es.iesclaradelrey.dm1e2122.examenpoo.ejercicio01a;

public class Cocodrilo extends Animal implements Reptil{
	private static final String NOMBRE_ESPECIE	= "COCODRILO";
	
	@Override
	public void comer(String comida) {
		System.out.println("Soy un " + NOMBRE_ESPECIE + " y estoy comiendo " + comida + ".");
	}
	
	@Override
	public void reptar(int distancia) {
		System.out.println("Soy un " + NOMBRE_ESPECIE + " y estoy reptando " + distancia + " metros.");		
	}

}
