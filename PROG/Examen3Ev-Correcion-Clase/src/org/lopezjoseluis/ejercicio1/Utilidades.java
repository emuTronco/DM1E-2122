package org.lopezjoseluis.ejercicio1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.lopezalvarezjoseluis.ejercicio1.Mascota;

public class Utilidades {
	public static final String APELLIDOS_NOMBRE = "lopezjoseluis";

	public static final String PATH_FICHERO_MASCOTAS = "src" + File.separator + "org" + File.separator
			+ APELLIDOS_NOMBRE + File.separator + "mascotas.dat";

	public static final String PATH_FICHERO_INFORME_MASCOTAS = "src" + File.separator + "org" + File.separator
			+ APELLIDOS_NOMBRE + File.separator + "mascotas.txt";

	public static List<Mascota> generarMascotas() {
		ArrayList<Mascota> mascotas = new ArrayList<>();

		mascotas.add(new Mascota("Lassie", "Perro", "Collie", 3));
		mascotas.add(new Mascota("Garfield", "Gato", "Americano de pelo corto", 8));
		mascotas.add(new Mascota("Pluto", "Perro", "Bloodhound", 3));
		mascotas.add(new Mascota("Hedwig", "Lechuza", "Bubo scandiacus", 5));
		mascotas.add(new Mascota("Pancho", "Perro", "Jack Russell", 4));
		mascotas.add(new Mascota("Jiffpom", "Perro", "Pomenrania", 9));
		mascotas.add(new Mascota("Nala", "Gato", "Siamés / Tabbimix", 7));
		mascotas.add(new Mascota("Marutaro", "Perro", "Shiba Inu", 5));

		return mascotas;
	}
}
