package es.iesclaradelrey.dm1e2122.ut14.ejemplos.ejemplo06transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Ejemplo06BSavepoints {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_IDIOMAS_1 = "insert into language (name) values ('Esperanto')";
	private static final String SQL_IDIOMAS_2 = "insert into language (name) values ('Klingon')";
	private static final String SAVEPOINT_ESPERANTO = "ESPERANTO";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement()) {

			// Cambiamos el modo de transacción
			// para que sean explícitas
			conn.setAutoCommit(false);
			
			// Ejecutamos la primera inserción
			st.executeUpdate(SQL_IDIOMAS_1);

			// Creamos un savepoint para este punto.
			Savepoint savepointEsperanto = conn.setSavepoint(SAVEPOINT_ESPERANTO);

			// Ejecutamos una segunda inserción
			st.executeUpdate(SQL_IDIOMAS_2);

			// Hacemos rollback hasta el savepoint
			// Esto deshace sólo la segunda SQL
			conn.rollback(savepointEsperanto);

			// Hacemos commit de la transacción. 
			conn.commit();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
