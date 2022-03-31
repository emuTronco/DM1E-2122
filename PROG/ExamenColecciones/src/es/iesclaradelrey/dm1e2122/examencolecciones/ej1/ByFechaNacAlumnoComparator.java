package es.iesclaradelrey.dm1e2122.examencolecciones.ej1;

import java.util.Comparator;

public class ByFechaNacAlumnoComparator implements Comparator <Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
	}

}
