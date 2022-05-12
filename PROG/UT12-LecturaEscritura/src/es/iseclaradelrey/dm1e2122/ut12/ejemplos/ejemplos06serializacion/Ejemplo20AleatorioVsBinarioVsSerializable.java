package es.iseclaradelrey.dm1e2122.ut12.ejemplos.ejemplos06serializacion;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

/**
 * 
 * Crea dos ficheros, uno usando RandomAccessFile, y otro usando
 * ObjectStreamWriter. En ambos ficheros escribe exclusivamente el número 255.
 * El objetivo es comparar ambos ficheros para entender la diferencia de
 * funcionamiento de ambos objetos.
 *
 */
public class Ejemplo20AleatorioVsBinarioVsSerializable {

	private static final String PATH_FICHERO_ALEATORIO = "FicherosPrueba" + File.separator + "fRandomAccessFile.dat";
	private static final String PATH_FICHERO_BINARIO = "FicherosPrueba" + File.separator + "fDataOutputStream.dat";
	private static final String PATH_FICHERO_SERIALIZABLE = "FicherosPrueba" + File.separator + "fObjectOutputStream.dat";

	public static void main(String args[]) {
		// Eliminamos los ficheros si existen, para evitar que se añadan datos a ellos.
		eliminarFichero(PATH_FICHERO_ALEATORIO);
		eliminarFichero(PATH_FICHERO_BINARIO);
		eliminarFichero(PATH_FICHERO_SERIALIZABLE);

		crearFicheroRandomAccessFile();
		crearFicheroDataOutputStream();
		crearFicheroObjectOutputStream();
	}

	private static void crearFicheroRandomAccessFile() {
		try (RandomAccessFile raf = new RandomAccessFile(PATH_FICHERO_ALEATORIO, "rw")) {
			raf.writeInt(255);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO_ALEATORIO);
		} catch (IOException e) {
			System.err.println("Error al acceder al fichero " + PATH_FICHERO_ALEATORIO);
			e.printStackTrace();
		}
		System.out.println("Creado fichero " + PATH_FICHERO_ALEATORIO);
	}

	private static void crearFicheroDataOutputStream() {
		try (DataOutputStream dof = new DataOutputStream(new FileOutputStream(PATH_FICHERO_BINARIO))) {
			dof.writeInt(255);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO_BINARIO);
		} catch (IOException e) {
			System.err.println("Error al acceder al fichero " + PATH_FICHERO_BINARIO);
			e.printStackTrace();
		}
		System.out.println("Creado fichero " + PATH_FICHERO_BINARIO);

	}

	private static void crearFicheroObjectOutputStream() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_FICHERO_SERIALIZABLE))) {
			oos.writeInt(255);
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + PATH_FICHERO_SERIALIZABLE);
		} catch (IOException e) {
			System.err.println("Error al acceder al fichero " + PATH_FICHERO_SERIALIZABLE);
			e.printStackTrace();
		}
		System.out.println("Creado fichero " + PATH_FICHERO_SERIALIZABLE);

	}
	
	private static void eliminarFichero(String pathfichero) {
		File f = new File(pathfichero);
		if (f.exists()) {
			f.delete();
		}
		System.out.println("Eliminado fichero " + pathfichero);
	}


}