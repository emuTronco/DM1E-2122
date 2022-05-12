package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos03basicos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * Copiar un fichero byte a byte usando streams de Java.
 *
 */
public class Ejemplo10CopiaFichero {

	// private static final String NOMBRE_CARPETA_PRUEBAS = "";
	private static final String NOMBRE_FICHERO_ENTRADA = "FicherosPrueba" + File.separator + "frases.txt";
	private static final String NOMBRE_FICHERO_SALIDA = "FicherosPrueba" + File.separator + "copiaDeFrases.txt";

	public static void main(String[] args) throws IOException {

		// Usamos un objeto file para comprobar que el fichero de origen existe. 
		File f = new File(NOMBRE_FICHERO_ENTRADA);

		if (!f.exists() || !f.isFile()) {
			System.out.println("No existe el fichero '" + f.getAbsolutePath() + "' o no es un fichero.");
		} else {

			// Usamos try-with-resources para garantizar el cierre de los ficheros.
			// El constructor de FileOutputStream tiene una sobrecarga con un parámetro para
			// poder añadir a en lugar de sobrescribir el fichero destino.
			try (FileInputStream in = new FileInputStream(NOMBRE_FICHERO_ENTRADA);
					FileOutputStream out = new FileOutputStream(NOMBRE_FICHERO_SALIDA)) {

				int c;
				while ((c = in.read()) != -1) {
					out.write(c);
				}

			}
		}
		
		
	}
	
	
}