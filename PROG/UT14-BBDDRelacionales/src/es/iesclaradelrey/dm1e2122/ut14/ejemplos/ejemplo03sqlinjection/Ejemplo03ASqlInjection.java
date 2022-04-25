package es.iesclaradelrey.dm1e2122.ut14.ejemplos.ejemplo03sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 
 * Ejemplo de cómo hacer inyección SQL si no se han protegido adecuadamente las
 * consultas. Ver
 * https://pentestmonkey.net/cheat-sheet/sql-injection/mysql-sql-injection-cheat-sheet
 * para una referencia de sentencias útiles para inyección SQL
 *
 * Prueba 1: ' OR '1' = '1
 * Prueba 2: '; insert into actor(first_name, last_name) values ('Actor', 'Inyectado'); select * from actor where '1'='1
 * 
 * 
 * 
 * Prueba 3:
 */

public class Ejemplo03ASqlInjection {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String nombre = "";
		while (!nombre.equalsIgnoreCase("-1")) {
			System.out.print("Introduce el nombre (-1 para terminar): ");
			nombre = sc.nextLine();
			if (!nombre.equalsIgnoreCase("-1")) {
				System.out.print("Introduce el apellido: ");
				String apellido = sc.nextLine();
				loginActor(nombre, apellido);
			}
		}
		System.out.println("Hasta la próxima...");
	}

	private static void loginActor(String nombre, String apellido) {
		String sql = String.format("select * from actor where first_name = '%s' and last_name = '%s'", nombre, apellido);
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			System.out.printf("\nDatos de actores según la consulta\n%s\n", sql);
			if (!rs.isBeforeFirst()) {
				System.out.println("No se han encontrado registros.");
			} else {

				mostrarDatosResultSet(rs);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static void mostrarDatosResultSet(ResultSet rs) throws SQLException {
		// Obtenemos la información de las columnas en el resultset
		ResultSetMetaData rsMetadata = rs.getMetaData();
		// Contamos cuantas colimnas hay
		int columnCount = rsMetadata.getColumnCount();
		// Recorremos las filas
		while (rs.next()) {
			// Y en cada fila las columnas
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + " ");
			}
			System.out.println();
		}
	}

}
