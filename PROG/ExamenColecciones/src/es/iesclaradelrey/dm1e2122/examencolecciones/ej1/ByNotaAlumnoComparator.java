package es.iesclaradelrey.dm1e2122.examencolecciones.ej1;

import java.util.Comparator;

public class ByNotaAlumnoComparator implements Comparator <Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		if (o1.getNotaMedia() < o2.getNotaMedia()) return -1;
		if (o1.getNotaMedia() > o2.getNotaMedia()) return 1;
		return 0;
	}

}
