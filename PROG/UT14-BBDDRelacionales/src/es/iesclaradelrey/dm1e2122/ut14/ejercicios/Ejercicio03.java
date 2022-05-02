package es.iesclaradelrey.dm1e2122.ut14.ejercicios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio03 {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_CUSTOMER = "select * from customer";
	private static final String PATH_FICHERO = "customer.bin";

	public static void main(String[] args) {
		exportarCustomers();
	}

	// Exporta los datos de la tabla customer en un fichero, usando serialziación.
	private static void exportarCustomers() {
		// Abrimos conexión, preparamos la sentencia SQL y la ejecutamos, obteniendo los
		// resultados en un ResultSet.
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement pst = conn.prepareStatement(SQL_CUSTOMER);
				ResultSet rs = pst.executeQuery()) {

			// Creamos el stream para volcar datos al fichero serializando
			try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(PATH_FICHERO))) {
				// Recorremos todos los registros
				while (rs.next()) {
					// Creamos un cliente a partir de la fila actual
					Customer c = getCurrentCustomer(rs);
					// Guardamos el cliente en el fichero.
					salida.writeObject(c);
				}
			}
			System.out.println("Fichero generado");
		} catch (SQLException | IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param rs Resultset a partir del cual se genera el cliente. Usa la fila
	 *           actual del Resultset para obtener los datos del cliente,
	 * @return Objeto cliente (Customer)
	 * @throws SQLException
	 */
	private static Customer getCurrentCustomer(ResultSet rs) throws SQLException {
		// Leemos cada uno de los datos del cliente en la BD, y lo pasamos al constructor del objeto. 
		return new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"),
				rs.getString("last_name"), rs.getString("email"), rs.getInt("address_id"),
				rs.getInt("active") == 0 ? false : true, rs.getTimestamp("create_date").toLocalDateTime(),
				rs.getTimestamp("last_update").toLocalDateTime());
	}
}
