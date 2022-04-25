package es.iesclaradelrey.dm1e2122.ut14.ejemplos.ejemplo03sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 
 * Uso de PreparedStatement, que entre otras cosas ayuda a proteger de la
 * inyección SQL
 * 
 */

public class Ejemplo03BPreparedStatement {

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
		// Las interrogaciones indican donde van los parámetros. No hace falta poner
		// comillas en los que son tipo texto.
		String sql = "select * from actor where first_name = ? and last_name = ?";
		// Al crear el PreparedStatement hay que pasar la sentencia SQL, para que se
		// pueda calcular (o recuperar si ya existe) el plan de ejecución.
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement st = conn.prepareStatement(sql)) {
			// Se añaden los parámetros por su posición, que empieza por el 1, no por cero.
			// No hay por qué añadirlos en orden.
			st.setString(1, nombre);
			st.setString(2, nombre);
			// La sobrecarga st.executeQuery(consulta) no se puede usar en un objeto
			// PreparedStatement. Se ejecuta la consulta que se definió al construir el
			// objeto.
			ResultSet rs = st.executeQuery();
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
