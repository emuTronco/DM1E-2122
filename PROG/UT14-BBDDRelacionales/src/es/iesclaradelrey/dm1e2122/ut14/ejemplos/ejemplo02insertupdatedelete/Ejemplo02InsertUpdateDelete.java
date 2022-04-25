package es.iesclaradelrey.dm1e2122.ut14.ejemplos.ejemplo02insertupdatedelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 * 
 * Ejemplo de inserción en una tabla y posterior modificación de los datos y
 * borrado de la fila. Entre cada una de las operaciones se mostrarán los datos.
 *
 */
public class Ejemplo02InsertUpdateDelete {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";

	public static void main(String[] args) {
		String apellidoActor = "Lopez";

		mostrarDatosActor(apellidoActor);
		insertarActor("Jose Luis", "Lopez Alvarez");
		mostrarDatosActor(apellidoActor);
		modificarActor("Lopez", "José Luis", "López Alvarez");
		mostrarDatosActor(apellidoActor);
		eliminarActor(apellidoActor);
		mostrarDatosActor(apellidoActor);
	}

	private static void insertarActor(String nombre, String apellidos) {
		// Se ponen nobres de columnas porque sólo damos valores a dos de ellas. El
		// resto la BBDD las calcula (id y fecha de actualización)
		String sql = String.format("insert into actor (first_name, last_name) values ('%s', '%s')", nombre, apellidos);
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement()) {
			System.out.printf("\nCreando actor con la sentencia\n%s\n", sql);
			int numFilasAfectadas = st.executeUpdate(sql);
			if (numFilasAfectadas == 0) {
				System.out.println("No se ha creado el actor.");
			} else {
				System.out.println("Actor creado");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static void modificarActor(String apellidoActor, String nuevoNombreActor, String nuevoApellidoActor) {
		// El % del like se escapa en Java cuando usamos String.format o printf duplicando el %.
		String sql = String.format("update actor set first_name = '%s', last_name = '%s' where last_name like '%%%s%%'",
				nuevoNombreActor, nuevoApellidoActor, apellidoActor);
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement()) {
			System.out.printf("\nCreando actor con la sentencia\n%s\n", sql);
			int numFilasAfectadas = st.executeUpdate(sql);
			if (numFilasAfectadas == 0) {
				System.out.println("No se ha actualizado el actor.");
			} else {
				System.out.println("Actor actualizado");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static void eliminarActor(String apellidoActor) {
		// El % del like se escapa en Java cuando usamos String.format o printf duplicando el %.
		String sql = String.format("delete from actor where last_name like '%%%s%%'", apellidoActor);
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement()) {
			System.out.printf("\nEliminando actor con la sentencia\n%s\n", sql);
			int numFilasAfectadas = st.executeUpdate(sql);
			if (numFilasAfectadas == 0) {
				System.out.println("No se ha eliminado el actor.");
			} else {
				System.out.println("Actor eliminado");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static void mostrarDatosActor(String apellidoActor) {
		// El % del like se escapa en Java cuando usamos String.format o printf duplicando el %.
		String sql = String.format(
				"select actor_id, first_name, last_name, last_update from actor where last_name like '%%%s%%'",
				apellidoActor);
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			System.out.printf("\nDatos del actor según la consulta\n%s\n", sql);
			if (!rs.isBeforeFirst()) {
				System.out.println("No se han encontrado registros.");
			} else {
				while (rs.next()) {
					int id = rs.getInt(1); // Por orden de columna, que comienzan en 1 y no en 0.
					String nombre = rs.getString("first_name"); // Por etiqueta (alias o nombre) de columna.
					String apellido = rs.getString("last_name"); // Por etiqueta (alias o nombre) de columna.
					LocalDateTime fechaActualizacion = rs.getTimestamp("last_update").toLocalDateTime();
					System.out.println(id + " - " + nombre + " - " + apellido + " - " + fechaActualizacion);
				}
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
