package es.iesclaradelrey.dm1e2122.ut14.ejemplos.ejemplo04callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Ejemplo de llamada a procedimientos almacenados usando parámetros por índice.
 *
 */
public class Ejemplo04ACallableStatement {

	// Específico de MySQL: para poder usar procedimientos almacenados pasando
	// parámetros por su posición, si no se han dado permisos de selección
	// mysql.proc, hay que añadir en la cadena de conexión una opción
	// "noAccessToProcedureBodies=true". Si se han dado permisos de selección sobre
	// mysql.proc, este parámetro no influye.

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila?noAccessToProcedureBodies=true";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";

	public static void main(String[] args) {
		System.out.println("Comprobando si hay stock de la película con id 1 en la tienda con id 1");
		int copiasDisponibles = obtenerStockPelicula(1, 1);
		System.out.printf("Hay %d copias disponibles de la película\n", copiasDisponibles);
	}

	private static int obtenerStockPelicula(int idPelicula, int idTienda) {
		String llamadaSp = "call film_in_stock(?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				CallableStatement st = conn.prepareCall(llamadaSp)) {
			// Se añaden los parámetros por nombre, que empieza por el 1, no por cero.
			// No hay por qué añadirlos en orden.
			st.setInt(1, idPelicula);
			st.setInt(2, idTienda);
			// El tercer parámetro es de salida. Hay que usar registerOutParameter,
			// indicando el tipo del parámetro que esperamos que se devuelva.
			st.registerOutParameter(3, java.sql.Types.INTEGER);
			st.execute();
			// Para recuperar el valor del parámetro se usa el su índice (posición).
			int stockPelicula = st.getInt(3);

			return stockPelicula;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			throw new RuntimeException("Error al obtener el stock de la película", ex);
		}
	}

}
