package org.lopezjoseluis.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ProgramaB {

	private static final String URL_DB = "jdbc:mysql://localhost/sakila";
	private static final String USUARIO_DB = "sakilauser";
	private static final String PWD_USUARIO_DB = "pwdsakilauser";
	private static final String DML_UPDATE_CLIENTE = "update customer set first_name = ?, last_name = ? where customer_id = ?";

	public static void main(String[] args) {
		Integer idCliente = pideNumero("Introduce id de cliente que quieres modificar", "Datos del cliente");
		String nombreCliente = pideCadena("Introduce el nuevo nombre del cliente", "Datos del cliente");
		String apellidosCliente = pideCadena("Introduce los nuevos apellidos del cliente", "Datos del cliente");

		// Vamos a validarlo todo de una vez, y sólo muestro un mensaje
		if (idCliente == null || nombreCliente.isEmpty() || apellidosCliente.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"El id del cliente tiene que ser un número entero, y los nuevos nombre y apellidos no pueden estar vacíos.",
					"Error", JOptionPane.ERROR_MESSAGE);
		} else {
			// Abrimos conexión y preparamos sentencia...
			try (Connection con = DriverManager.getConnection(URL_DB, USUARIO_DB, PWD_USUARIO_DB);
					PreparedStatement ps = con.prepareStatement(DML_UPDATE_CLIENTE)) {
				// Configuramos parámetros
				ps.setString(1, nombreCliente);
				ps.setString(2, apellidosCliente);
				ps.setInt(3, idCliente);

				int numRegistros = ps.executeUpdate();

				JOptionPane.showMessageDialog(null, String.format("Se han actualizado %d registros.", numRegistros),
						"Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"Se ha producido un error en acceso a la base de datos: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

		}

	}

	private static String pideCadena(String mensaje, String tituloVentana) {
		String cadena = JOptionPane.showInputDialog(null, mensaje, tituloVentana, JOptionPane.QUESTION_MESSAGE);
		if (cadena == null) {
			cadena = "";
		}
		cadena = cadena.trim();
		return cadena;
	}

	private static Integer pideNumero(String mensaje, String tituloVentana) {
		String cadenaNumero = JOptionPane.showInputDialog(null, mensaje, tituloVentana, JOptionPane.QUESTION_MESSAGE);
		if (cadenaNumero == null)
			return null;
		Integer num = null;
		try {
			num = Integer.parseInt(cadenaNumero);
		} catch (NumberFormatException e) {
			// No hago nada aquí. Devuelvo nulo.
		}
		return num;

	}
}
