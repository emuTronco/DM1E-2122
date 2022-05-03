package es.iesclaradelrey.dm1e2122.ut14.ejercicios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Ejercicio05 {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_CUSTOMER = "select * from customer";
	private static final String SQL_OLD_CUSTOMER = "select * from old_customer";

	private static final String PATH_FICHERO = "customer.bin";

	public static void main(String[] args) {
		eliminarOldCustomers();
		importarOldCustomers();
	}

	private static void eliminarOldCustomers() {
		// Abrimos conexión y preparamos la sentencia SQL
		// Como queremos usar el método deleteRow() tenemos que abrir un objeto prepared
		// statement que permita eliminar.También ejecutamos la sentencia. Como es un
		// select, usamos executeQuery para obtener
		// el resultset.
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement pst = conn.prepareStatement(SQL_OLD_CUSTOMER, ResultSet.TYPE_FORWARD_ONLY,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = pst.executeQuery();) {
			// Recorremos el ResultSet eliminando
			// Vamos a contar cuántos registros vamos eliminado.
			int numFilasEliminadas = 0;
			while (rs.next()) {
				System.out.printf("Eliminado registro con id %d.\n", rs.getInt("customer_id"));
				rs.deleteRow();
				numFilasEliminadas++;
			}

			// Mostramos un mensaje indicando número de filas eliminadas.
			System.out.printf(
					"Se han eliminado los registros de la tabla old_customer. Se han eliminado %d registros.\n",
					numFilasEliminadas);

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

	// Exporta los datos de la tabla customer en un fichero, usando serialización.
	
	@SuppressWarnings("unused")
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

	// Importa los datos previamente exportados.
	private static void importarOldCustomers() {
		// Abrimos conexión a la BD.
		// No hay que preparar una sentencia de inserción, sino una sentencia que
		// produce un ResultSet actualizable, porque queremos usar insertRow().
		// Podemos recuperar ya el resultset directamente en este try-with-resources.
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement pst = conn.prepareStatement(SQL_OLD_CUSTOMER, ResultSet.TYPE_FORWARD_ONLY,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = pst.executeQuery()) {

			// Abrimos el fichero con los datos serializados previamente.
			try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(PATH_FICHERO))) {
				// Leemos todos los objetos. Usamos la excepción EOFException para cortar la
				// lectura.
				try {
					while (true) {
						Customer c = (Customer) entrada.readObject();
						addCustomerToResultSet(c, rs);
						System.out.printf("Insertado registro con id %d.\n", c.getCustomerId());
					}
				} catch (EOFException ex) {
					System.out.println("Se ha alcanzado el final del fichero.");
					System.out.println("Fichero importado");
				} catch (ClassNotFoundException e) {
					System.out.println("Se ha producido una excepción por clase no encontrada.");
				}

			}

		} catch (SQLException | IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static void addCustomerToResultSet(Customer c, ResultSet rs) throws SQLException {
		// Saltamos a la fila de inserción
		rs.moveToInsertRow();

		// Establecemos valores de las columnas:
		rs.updateInt("customer_id", c.getCustomerId());
		rs.updateInt("store_id", c.getStoreId());
		rs.updateString("first_name", c.getFirstName());
		rs.updateString("last_name", c.getLastName());
		rs.updateString("email", c.getEmail());
		rs.updateInt("address_id", c.getAddressId());
		rs.updateInt("active", c.isActive() ? 1 : 0);
		rs.updateTimestamp("create_date", Timestamp.valueOf(c.getFechaCreacion()));
		rs.updateTimestamp("last_update", Timestamp.valueOf(c.getFechaActualizacion()));

		// Guardamos la fila
		rs.insertRow();
	}

	/**
	 * 
	 * @param rs Resultset a partir del cual se genera el cliente. Usa la fila
	 *           actual del Resultset para obtener los datos del cliente,
	 * @return Objeto cliente (Customer)
	 * @throws SQLException
	 */
	private static Customer getCurrentCustomer(ResultSet rs) throws SQLException {
		// Leemos cada uno de los datos del cliente en la BD, y lo pasamos al
		// constructor del objeto.
		return new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"),
				rs.getString("last_name"), rs.getString("email"), rs.getInt("address_id"),
				rs.getInt("active") == 0 ? false : true, rs.getTimestamp("create_date").toLocalDateTime(),
				rs.getTimestamp("last_update").toLocalDateTime());
	}
}
