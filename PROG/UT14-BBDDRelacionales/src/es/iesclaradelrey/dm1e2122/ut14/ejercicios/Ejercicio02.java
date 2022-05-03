package es.iesclaradelrey.dm1e2122.ut14.ejercicios;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio02 {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_INFORME = """
			SELECT CONCAT(customer.last_name, ', ', customer.first_name) AS customer,
			       address.phone,
			       film.title,
			       rental.rental_date,
			       rental_date + INTERVAL film.rental_duration DAY       AS expected_return_date,
			       datediff(now(), rental_date + INTERVAL film.rental_duration DAY) as delay_days
			       
			FROM rental
			         INNER JOIN customer ON rental.customer_id = customer.customer_id
			         INNER JOIN address ON customer.address_id = address.address_id
			         INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id
			         INNER JOIN film ON inventory.film_id = film.film_id
			WHERE rental.return_date IS NULL
			  AND rental_date + INTERVAL film.rental_duration DAY < CURRENT_DATE()
			ORDER BY delay_days desc;""";
	private static final String PATH_FICHERO = "salidaEjercicio02.txt";

	public static void main(String[] args) throws FileNotFoundException {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement pst = conn.prepareStatement(SQL_INFORME);
				ResultSet rs = pst.executeQuery()) {

			//PrintStream salida = System.out;
			try (PrintStream salida = new PrintStream(PATH_FICHERO)) {

				// Comprobamos si hay registros.
				if (!rs.isBeforeFirst()) {
					throw new RuntimeException("No se han devuelto datos en la consulta.");
				}
				// Poner cabecera
				int[] tamanios = { 92, 20, 128, 12, 12, 12 };
				lineaSeparacion(tamanios, salida);
				salida.printf("| %-92s | %20s | %-128s | %12s | %12s | %12s |\n", "Cliente", "Teléfono", "Película",
						"Alquilada", "A devolver", "Días retraso");

				// Recorremos los registros obtenidos
				while (rs.next()) {
					lineaSeparacion(tamanios, salida);
					salida.printf("| %-92s | %20s | %-128s | %12s | %12s | %12d |\n", rs.getString("customer"),
							rs.getString("phone"), rs.getString("title"), rs.getDate("rental_date"),
							rs.getDate("expected_return_date"), rs.getInt("delay_days"));
				}		
				lineaSeparacion(tamanios, salida);
			}
	

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		System.out.println("Fichero generado");
	}

	private static void lineaSeparacion(int[] tamanioColumnas, PrintStream salida) {
		int tamanioLinea = 0;
		for (int tam : tamanioColumnas) {
			tamanioLinea += (tam + 2);
		}
		tamanioLinea += (tamanioColumnas.length + 1);
		salida.println("-".repeat(tamanioLinea));
	}

}
