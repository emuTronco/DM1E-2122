package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos04binarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Este ejemplo permite copiar un fichero binario (imagen jpg) en otro fichero jpg.
public class Ejemplo13CopiarBinario {
	private static final String IMG_ORIGINAL_1 = "FicherosPrueba" + File.separator + "1.jpg";
	private static final String IMG_COPIA_1 = "FicherosPrueba" + File.separator + "1-copia.jpg";

	private static final String IMG_ORIGINAL_2 = "FicherosPrueba" + File.separator + "2.jpg";
	private static final String IMG_COPIA_2 = "FicherosPrueba" + File.separator + "2-copia.jpg";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		copyByteAByte();
		copyPorBloques();
	}

	private static void copyByteAByte() throws IOException, FileNotFoundException {
		System.out.println("Vamos a copiar un fichero byte a byte.");
		
		// Como siempre que podamos, usamos try-with-resources para 
		// garantizar el cierre del fichero.
		try (FileInputStream fi = new FileInputStream(IMG_ORIGINAL_1);
				FileOutputStream fo = new FileOutputStream(IMG_COPIA_1)) {
			int byteLeido;
			while ((byteLeido = fi.read()) != -1) {
				fo.write(byteLeido);
			}
		}
		System.out.println("Fichero copiado byte a byte.");
	}
	
	private static void copyPorBloques() throws FileNotFoundException, IOException {
		System.out.println("Vamos a copiar un fichero por bloques.");
		
		// Creamos un array de bytes para copiar por bloques
		final int MAX_BYTES = 40000;
		byte[] bytesLeidos = new byte[MAX_BYTES];
		
		// Usamos try-with-resources para garantizar el cierre del fichero.
		try (FileInputStream fi = new FileInputStream(IMG_ORIGINAL_2);
				FileOutputStream fo = new FileOutputStream(IMG_COPIA_2)) {
			int numBytesLeidos = fi.read(bytesLeidos);
			while (numBytesLeidos != -1)
			{
				fo.write(bytesLeidos, 0, numBytesLeidos);
				//fo.write(bytesLeidos, 0, 256);
				numBytesLeidos = fi.read(bytesLeidos);	
				if (numBytesLeidos < 256) {
					System.out.println("La úeltima lectura han sido " + numBytesLeidos);
				}
			}
			
			
//			int numBytesLeidos ;
//			while ((numBytesLeidos = fi.read(bytesLeidos)) != -1)
//			{
//				fo.write(bytesLeidos, 0, numBytesLeidos);
//			}

			
		}
		
		System.out.println("Fichero copiado por bloques.");
	}
}
