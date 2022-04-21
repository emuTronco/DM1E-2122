package es.iesclaradelrey.dm1e2122.examenrec2ev.ej2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programa {

	public static void main(String[] args) {

		List<Electrodomestico> electrodomesticos = new ArrayList<>();

		electrodomesticos.add(new Electrodomestico("Siemens", "EX2230", 60, 230, 60, Potencia.BAJA));
		electrodomesticos.add(new Electrodomestico("Balay", "H90", 60, 60, 60, Potencia.MEDIA));
		electrodomesticos.add(new Electrodomestico("Balay", "T12R", 80, 160, 60, Potencia.ALTA));
		electrodomesticos.add(new Electrodomestico("Balay", "T12R", 80, 160, 60, Potencia.ALTA)); // Repetido.
		electrodomesticos.add(new Electrodomestico("Siemens", "EX2231", 60, 230, 60, Potencia.MUY_BAJA));
		electrodomesticos.add(new Electrodomestico("Teka", "CE2110", 60, 105, 48, Potencia.ALTA));
		electrodomesticos.add(new Electrodomestico("Teka", "CE2110+", 60, 105, 48, Potencia.MEDIA));
		electrodomesticos.add(new Electrodomestico("Teka", "CE2110+", 60, 105, 48, Potencia.MEDIA)); // Repetido.
		electrodomesticos.add(new Electrodomestico("Teka", "HR9000", 60, 60, 60, Potencia.MUY_ALTA));
		electrodomesticos.add(new Electrodomestico("Teka", "HR9000", 60, 60, 60, Potencia.MUY_ALTA)); // Repetido.
		electrodomesticos.add(new Electrodomestico("Teka", "HR9000", 60, 60, 60, Potencia.MUY_ALTA)); // Repetido.

		System.out.println("Listado de electrodomésticos ordenados por marca y modelo.");
		// TODO: Listar los electrodomésticos por marca y modelo. Se aconseja
		// implementar un método en este programa para hacerlo.
		listarElectrodomesticos(electrodomesticos);

		System.out.println("Eliminado duplicados de la lista");
		// TODO: Eliminar repetidos en la lista. Se aconseja implementar un método en
		// este programa para hacerlo. Eliminar repetidos significa que si hay tres
		// electrodomésticos con la misma marca y modelo debe quedar sólo uno de ellos.
		// No importa cuál de los que había originalmente se mantiene.
		eliminarDuplicados(electrodomesticos);

		System.out.println("Listado de electrodomésticos ordenados por volumen.");
		// TODO: Listar los electrodomésticos por volumen, de mayor a menor. Se aconseja
		// implementar un método en este programa para hacerlo.

		System.out.println("Listado de electrodomésticos ordenados por volumen (descendente).");
		// TODO: Listar los electrodomésticos por volumen, de mayor a menor. Se aconseja
		// implementar un método en este programa para hacerlo.
	}

	private static void listarElectrodomesticos(List<Electrodomestico> electrodomesticos) {
		List<Electrodomestico> ordenados = new ArrayList<>(electrodomesticos);
		Collections.sort(ordenados);
		for (Electrodomestico electrodomestico : ordenados) {
			System.out.println(electrodomestico);
		}
	}

	private static void eliminarDuplicados(List<Electrodomestico> electrodomesticos) {
	}

}
