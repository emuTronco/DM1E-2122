package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos03basicos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo06LeerFichero {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Este fichero se debe encontrar dentro del directorio donde se ejecuta el
		// programa. Si estamos en Eclipse, dentro de la carpeta del proyecto.
		try (FileReader fr = new FileReader("FicherosPrueba/frases.txt")) {
			int c;
			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
		}

	}
}
