package es.iesclaradelrey.dm1e2122.ut14.ejemplos.ejemplo05insertupdatedelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo05CDeleteRow {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_IDIOMAS = "select language_id, name from language where name = 'Esperanto'";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery(SQL_IDIOMAS)) {

			// Comprobamos si hay un registro para "Esperanto"
			if (!rs.isBeforeFirst()) {
				System.out.println("No se han encontrado registros para el idioma 'Esperanto'");
			} else {
				System.out.println("Encontrados registros para el idioma 'Esperanto'. Procedemos a borrarlos.");
			}

			// Borramos uno a uno
			while (rs.next()) {
				String id = rs.getString("language_id");
				System.out.printf("Eliminado idioma con id %s.\n", id);
				rs.deleteRow();
			}

			// Abrir un ResultSet con ResultSet.CONCUR_UPDATABLE 
			// que busque los registros que queremos eliminar.
			while (rs.next()) {
				// Borrar registros a medida que se recorren
				rs.deleteRow();
			}

			
			
			// Volvemos al principio del resultset
			rs.beforeFirst();

			// Comprobamos si hay un registro para "Esperanto"
			if (!rs.isBeforeFirst()) {
				System.out.println("No se han encontrado registros para el idioma 'Esperanto'");
			} else {
				System.out.println("Encontrados registros para el idioma 'Esperanto'. El borrado debe haber fallado.");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
