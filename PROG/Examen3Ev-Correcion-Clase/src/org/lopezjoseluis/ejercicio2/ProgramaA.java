package org.lopezjoseluis.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ProgramaA {

	private static final String URL_DB = "jdbc:mysql://localhost/sakila";
	private static final String USUARIO_DB = "sakilauser";
	private static final String PWD_USUARIO_DB = "pwdsakilauser";
	private static final String SQL_BUSQUEDA = "select customer_id, first_name, last_name from customer where first_name like ? or last_name like ?";

	public static void main(String[] args) {

		String cadenaBusqueda = pideCadenaBusqueda();

		while (!cadenaBusqueda.equalsIgnoreCase("fin")) {
			if (cadenaBusqueda.length() < 3) {
				JOptionPane.showMessageDialog(null, "La cadena de búsqueda debe tener al menos 3 caracteres",
						"Error en cadena de búsqueda", JOptionPane.ERROR_MESSAGE);
			} else {
				cadenaBusqueda = "%" + cadenaBusqueda + "%";

				try (Connection con = DriverManager.getConnection(URL_DB, USUARIO_DB, PWD_USUARIO_DB);
						PreparedStatement ps = con.prepareStatement(SQL_BUSQUEDA)) {

					ps.setString(1, cadenaBusqueda);
					ps.setString(2, cadenaBusqueda);
					
					try (ResultSet rs = ps.executeQuery()) {
						if (!rs.isBeforeFirst()) {
							JOptionPane.showMessageDialog(null, "No se han obtenido resultados", "Atención",
									JOptionPane.WARNING_MESSAGE);
						} else {
							while (rs.next()) {
								System.out.printf("%d - %s - %s\n", rs.getInt("customer_id"),
										rs.getString("first_name"), rs.getString("last_name"));
							}
						}
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos: " + e.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}

			cadenaBusqueda = pideCadenaBusqueda();
		}
	}

	private static String pideCadenaBusqueda() {
		String cadenaBusqueda = JOptionPane.showInputDialog(null, "Introduce la cadena a buscar");
		if (cadenaBusqueda == null) {
			cadenaBusqueda = "";
		}
		cadenaBusqueda = cadenaBusqueda.trim();
		return cadenaBusqueda;
	}

}
