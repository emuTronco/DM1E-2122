package es.iseclaradelrey.dm1e2122.ut12.ejercicios;

import java.io.File;
import java.io.IOException;

public class Ejercicio01 {

	public static void main(String[] args) throws IOException {
		// Ejemplo de cómo crear y eliminar carpetas / directorios.
		crearYEliminarDirectorio();

		// Ejemplo de cómo crear una cadena de directorios.
		crearCadenaDeDirectorios();

	}

	/**
	 * Método que demuestra como crear y eliminar directorios. Cada vez que se
	 * ejecuta intenta crear un directorio determinado si no existe ya. Si ya
	 * existe, lo intenta eliminar.
	 */
	private static void crearYEliminarDirectorio() {

		// Crear carpeta / directorio "ficheros-de-prueba-borrar"

		// Para que el código funcione perfectamente en todos los sistemas, cuando
		// montamos un path lo mejor es usar File.separator para las barras
		// (/ o \), así funcionará tantoen unix como en Windows.

		// Montamos el path del directorio padre en el que queremos crear el directorio
		// Esta carpeta / directorio puede no ser válido en todos los sistemas
		String pathEscritorio = System.getProperty("user.home") + File.separator + "Desktop";

		// Creamos el objeto File. Recordad que esto no crea el directorio o fichero
		// realmente, sólo crea una abstracción del fichero o directorio según su
		// nombre.
		File directorio = new File(pathEscritorio, "ficheros-de-prueba-borrar");

		// Comprobamos si existe el directorio. Si existe se borra, si no, se crea.
		if (directorio.exists()) {
			System.out.println("El directorio " + directorio.getAbsolutePath() + " ya existe.");
			if (directorio.delete()) {
				System.out.println("Directorio " + directorio.getAbsolutePath() + " eliminado.");
			} else {
				System.out.println("No he podido borrar el directorio " + directorio.getAbsolutePath());
			}
		} else {
			System.out.println("El directorio " + directorio.getAbsolutePath() + " no existe.");

			// En la sentencia "if (directorio.mkdir())" estamos haciendo en una sóla línea
			// lo mismo que en la siguientes líneas:
			// boolean ok = directorio.mkdir();
			// if (!ok) {
			// // ...
			// }

			// Si quisiéramos crear un fichero en lugar de un directorio usaríamos
			// .createNewFile() en lugar de .mkdir()
			if (directorio.mkdir()) {
				System.out.println("Directorio " + directorio.getAbsolutePath() + " creado.");
			} else {
				System.out.println("No he podido crear el directorio " + directorio.getAbsolutePath());
			}
		}
	}

	/**
	 * Método que demuestra cómo crear un directorio junto a toda la cadena de
	 * directorios (ancestros) necesaria para crearlo.
	 */
	private static void crearCadenaDeDirectorios() {
		// Montamos el path sobre el que vamos a trabajar.
		// Esta carpeta puede no ser válida en todos los sistemas.
		String pathEscritorio = System.getProperty("user.home") + File.separator + "Desktop";

		// Creamos dinámicamente un path con 10 directorios, del 0 al 9.
		// Obtendremos algo así como 0/1/2/3/4/5/6/7/8/9
		String cadenaDirectorios = "";
		for (int i = 0; i < 10; i++) {
			cadenaDirectorios += i + File.separator;
		}

		// Creamos el objeto File. Recordad que esto no crea realmente el directorio.
		File directorio = new File(pathEscritorio, cadenaDirectorios);

		// Traza para ver lo que estamos a punto de crear
		System.out.println(directorio.getAbsolutePath());

		// Creamos el directorio. Si usáramos ".mkdir()", si no existen los directorios
		// del 0 al 8, la llamada falla. Con .mkdirs() se crean todos los directorios.
		if (!directorio.mkdirs()) {
			System.out.println("Ha fallado");
		} else {
			System.out.println("Ha funcionado");
		}

	}

}
