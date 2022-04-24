package es.iesclaradelrey.dm1e2122.ut08.ejercicios.ejercicio09;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author jllopezalvarez
 */
public class Programa {
	/**
	 * 
	 * @author jllopezalvarez Enumerado para operaciones disponibles. Se ha ampliado
	 *         con una propiedad para el símbolo matemático asociado a la operación,
	 *         y su correspondiente getter, para facilitar su representación
	 * 
	 */
	private enum Operacion {
		UNION("+"), INTERSECCION("*"), DIFERENCIA("-");

		private String simbolo;

		private Operacion(String simbolo) {
			this.simbolo = simbolo;
		}

		public String getSimbolo() {
			return simbolo;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Preguntamos la operación.
		System.out.println(
				"Introduce la operación a realizar. De la forma [conjunto] <operador> [conjunto]. Operadores válidos: +, *, -.");
		String linea = sc.nextLine();

		// Extraemos la operación.
		Operacion opSolicitada = extraerOperacion(linea);
		if (opSolicitada == null) {
			System.out.println("La operación no es válida");
		} else {
			// Creamos conjuntos
			Set<Integer> a = new HashSet<>();
			Set<Integer> b = new HashSet<>();
			// Extraemos operandos
			extraerOperandos(linea, a, b);

			// Creamos una variable para el resultado. Copiamos los valores
			// del primer operando al usar el constructor que recibe un conjunto.
			// Así no se modifica el primer operando.
			Set<Integer> resultado = new HashSet<>(a);

			// En función de la operación usamos el método adecuado del interfaz Set
			switch (opSolicitada) {
			case UNION:
				resultado.addAll(b);
				break;
			case INTERSECCION:
				resultado.retainAll(b);
				break;
			case DIFERENCIA:
				resultado.removeAll(b);
				break;
			}

			// Mostramos el resultado.
			System.out.format("%s %s %s = %s\n", a, opSolicitada.getSimbolo(), b, resultado);
		}

		sc.close();
	}

	/**
	 * Extrae de la línea a procesar la operación que se debe realizar. Intenta
	 * localizar operaciones en este orden: +, *, -. Si hay más de una de ellas,
	 * sólo tiene en cuenta la primera que encuentre en ese orden.
	 * 
	 * @param linea La línea que tenemos que analizar para detectar la operación a
	 *              realizar.
	 * @return La operación que se debe realizar, o null si linea es null o si no
	 *         hay ninguna operación válida en la línea.
	 */
	private static Operacion extraerOperacion(String linea) {
		if (linea == null)
			return null;
		if (linea.contains("+"))
			return Operacion.UNION;
		if (linea.contains("*"))
			return Operacion.INTERSECCION;
		if (linea.contains("-"))
			return Operacion.DIFERENCIA;
		return null;
	}

	/**
	 * Extrae de la línea que recibe como parámetro los valores de los dos
	 * conjuntos. Los del primer operando los incluye en el conjunto a, y los del
	 * segundo en el conjunto b.
	 * 
	 * @param linea Línea a procesar, de la que se deben extraer los operandos. Debe
	 *              ser de la forma "[conjunto] operación [conjunto]".
	 * @param a     Conjunto que constituye el primer opernado.
	 * @param b     Conjunto que constituye el segundo opernado.
	 */
	private static void extraerOperandos(String linea, Set<Integer> a, Set<Integer> b) {
		// Dividimos la cadena en dos partes, a la izquierda y a la derecha del
		// operando. La expresión regular "[\\*\\+\\-]" indica que se puede dividir por
		// cualquiera de los tres caracteres: *, +, -.
		String[] operandos = linea.split("[\\*\\+\\-]");
		// Eliminar de cada una de las partes los corchetes
		operandos[0] = operandos[0].replaceAll("\\[", "").replaceAll("\\]", "");
		operandos[1] = operandos[1].replaceAll("\\[", "").replaceAll("\\]", "");
		// Extraer elementos del primer conjunto
		extraerOperandos(operandos[0], a);
		// Extraer elementos del segundo conjunto
		extraerOperandos(operandos[1], b);
	}

	/**
	 * Extrae de textoConjunto los valores del conjunto, los convierte a enteros, y
	 * los añade al conjunto. Los elementos del conjunto deben estar separados por
	 * coma (,).
	 * 
	 * @param textoConjunto El conjunto expresado en forma de cadena de texto.
	 *                      Admite números separados por comas, rodeados o no por
	 *                      [].
	 * @param conjunto      El conjunto en el que almacenar los valores parseados de
	 *                      la cadena "textoConjunto"
	 */
	private static void extraerOperandos(String textoConjunto, Set<Integer> conjunto) {

		for (String num : textoConjunto.split(",")) {
			conjunto.add(Integer.parseInt(num.trim()));
		}
	}
}
