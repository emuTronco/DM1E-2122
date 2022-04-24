// Programa para demostrar el casting de los tipos primitivos

package es.iesclaradelrey.dm1e2122.ejemplos.polimorfismo.dinamico.ejemplo02casting;

public class ProgramaCastingPrimitivos {
	public static void main(String[] args) {
		
		// Entero de 32 bits
		int i = 3423; 

		// Casting implícito de entero de 32 bits 
		// a entero de 64 bits. Se puede hacer 
		// porque el tamaño de double es mayor que el de int.
		double d = i;  
		
		// Para cambiar desde un tamaño mayor 
		// a uno menor tenemos que hacer el cast explícito
		// Si no, falla al compilar. Al ser de más a menos 
		// bits puede haber pérdida de datos. 
		i= (int)d; 
	}
}
