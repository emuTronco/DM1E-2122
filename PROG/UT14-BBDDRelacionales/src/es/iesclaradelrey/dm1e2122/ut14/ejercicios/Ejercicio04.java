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
import java.util.Scanner;

public class Ejercicio04 {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_CUSTOMER = "select * from customer";
	private static final String SQL_DELETE_OLD_CUSTOMER = "delete from old_customer";
	private static final String SQL_INSERT_CUSTOMER = "insert into old_customer values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String PATH_FICHERO = "customer.bin";

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		eliminarOldCustomers();
		importarOldCustomers();
	}

	private static void eliminarOldCustomers() {
		// Abrimos conexión y preparamos la sentencia SQL-
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE_OLD_CUSTOMER)) {

			// Ejecutamos la sentencia. Como es un delete, usamos executeUpdate, que nos
			// devuelve el número de filas que se han eliminado.
			int numFilasEliminadas = pst.executeUpdate();

			// Mostramos un mensaje indicando número de filas eliminadas.
			System.out.printf(
					"Se han eliminado los registros de la tabla old_customer. Se han eliminado %d registros.\n",
					numFilasEliminadas);

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

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

	// Importa los datos previamente exportados.
	private static void importarOldCustomers() {
		// Abrimos conexión a la BD y preparamos la sentencia de inserción
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT_CUSTOMER)) {

			// Abrimos el fichero con los datos serializados previamente.
			try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(PATH_FICHERO))) {
				// Leemos todos los objetos. Usamos la excepción EOFException para cortar la
				// lectura.
				try {
					while (true) {
						Customer c = (Customer) entrada.readObject();
						addParameters(pst, c);
						if (pst.executeUpdate() > 0) {
							System.out.printf("Insertado registro con id %d.\n", c.getCustomerId());
						}
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

	private static void addParameters(PreparedStatement pst, Customer c) throws SQLException {
		pst.setInt(1, c.getCustomerId());
		pst.setInt(2, c.getStoreId());
		pst.setString(3, c.getFirstName());
		pst.setString(4, c.getLastName());
		pst.setString(5, c.getEmail());
		pst.setInt(6, c.getAddressId());
		pst.setInt(7, c.isActive() ? 1 : 0);
		pst.setTimestamp(8, Timestamp.valueOf(c.getFechaCreacion()));
		pst.setTimestamp(9, Timestamp.valueOf(c.getFechaActualizacion()));
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
