package es.iesclaradelrey.dm1e2122.ut14.ejemplos.ejemplo05insertupdatedelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo05BInsertRow {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_IDIOMAS = "select language_id, name from language";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery(SQL_IDIOMAS)) {

			// Vemos los datos antes de modificarlos.
			System.out.printf("\nDatos en el ResultSet antes de modificarlo:\n");
			while (rs.next()) {
				String c1 = rs.getString("language_id");
				String c2 = rs.getString("name");
				System.out.println(c1 + " - " + c2);
			}

			// Saltamos a la fila de inserción y fijamos valores editables 
			// (no autonuméricos o valores con default)
			rs.moveToInsertRow();
			rs.updateString("name", "Esperanto");
			// Añadimos el registro
			rs.insertRow();

			// Volvemos al principio del resultset
			rs.beforeFirst();

			// Vemos los datos después de modificarlos.
			System.out.printf("\nDatos en el ResultSet después de modificarlo:\n");
			while (rs.next()) {
				String c1 = rs.getString("language_id");
				String c2 = rs.getString("name");
				System.out.println(c1 + " - " + c2);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
