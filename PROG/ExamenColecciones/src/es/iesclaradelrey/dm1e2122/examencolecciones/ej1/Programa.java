package es.iesclaradelrey.dm1e2122.examencolecciones.ej1;

public class Programa {

	public static void main(String[] args) {
		Secretaria sec = new Secretaria();

		System.out.println("\n\n\n\n\nEjecución del modelo A:\n");
		grupoA(sec);

		System.out.println("\n\n\n\n\nEjecución del modelo B:\n");
		grupoB(sec);
	}

	private static void grupoA(Secretaria sec) {
		sec.clear();

		sec.addAlumno("111111A", "Dexter", "Morgan", "2001-06-15", 8.5d);
		sec.addAlumno("888888H", "Hanna", "McKay", "2001-10-25", 9.2d);
		sec.addAlumno("222222B", "Rita", "Bennet", "2005-06-12", 8.8d);
		sec.addAlumno("777777G", "Debra", "Morgan", "2000-12-15", 8.2d);
		sec.addAlumno("333333C", "María", "Laguerta", "2006-10-13", 7.5d);
		sec.addAlumno("666666F", "Joey", "Quinn", "2006-12-10", 6.7d);
		sec.addAlumno("444444D", "Angel", "Batista", "1999-10-05", 7.1d);
		sec.addAlumno("555555E", "Vince", "Masuka", "2001-01-15", 7.8d);

		
		
		sec.listarPorDni();

		sec.eliminarAlumno("222222B");

		sec.eliminarAlumno("999999X");

		sec.redondearNotas();

		sec.listarPorDniDescendente();

		sec.eliminarMenoresEdad();

		sec.listarPorDni();

		sec.listarPorNota();

		sec.listarPorNotaDescendente();
	}

	private static void grupoB(Secretaria sec) {
		sec.clear();

		sec.addAlumno("111111A", "Dexter", "Morgan", "2001-06-15", 8.5d);
		sec.addAlumno("888888H", "Hanna", "McKay", "2001-10-25", 9.2d);
		sec.addAlumno("222222B", "Rita", "Bennet", "2005-06-12", 8.8d);
		sec.addAlumno("777777G", "Debra", "Morgan", "2000-12-15", 8.2d);
		sec.addAlumno("333333C", "María", "Laguerta", "2006-10-13", 7.5d);
		sec.addAlumno("666666F", "Joey", "Quinn", "2006-12-10", 6.7d);
		sec.addAlumno("444444D", "Angel", "Batista", "1999-10-05", 7.1d);
		sec.addAlumno("555555E", "Vince", "Masuka", "2001-01-15", 7.8d);

		sec.listarPorDni();

		sec.cambiarNotaAlumno("222222B", 5.5d);

		sec.cambiarNotaAlumno("999999X", 5.5d);

		sec.redondearNotas();

		sec.listarPorDniDescendente();

		sec.eliminarMenoresEdad();

		sec.listarPorDni();

		sec.listarPorFechaNacimiento();

		sec.listarPorFechaNacimientoDescendente();
	}
}
