package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos03basicos;

import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo07EscribirFichero {

	public static void main(String[] args) throws IOException {

		// Este fichero se creará dentro del directorio donde se ejecuta el
		// programa. Si estamos en Eclipse, dentro de la carpeta del proyecto.
		try (FileWriter fw = new FileWriter("FicherosPrueba/salidaNueva.txt", true)) {
			String frasesAEscribir = "Frase uno.\nFrase dos.";
			fw.write(frasesAEscribir);
		}

	}
}
