package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado.clases.Pelicula;

public class DataAccess {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";
	private static final String SQL_GET_PELICULAS = """
			select film_id, title, description, release_year, l.name as language
			from film left join language l on film.language_id = l.language_id""";
	private static final String SQL_GET_PELICULA_BY_ID = """
			select film_id, title, description, release_year, l.name as language
			from film left join language l on film.language_id = l.language_id
			where film_id = ?""";

	public static List<Pelicula> getAllPeliculas() {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SQL_GET_PELICULAS)) {
			List<Pelicula> peliculas = new ArrayList<>();
			while (rs.next()) {
				peliculas.add(crearPelicula(rs));
			}
			return peliculas;
		} catch (SQLException ex) {
			throw new DataAccessException(SQL_GET_PELICULAS, "Error al recuperar todas las películas", ex);
		}
	}

	public static Pelicula getPeliculaById(int idPelicula) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement st = conn.prepareStatement(SQL_GET_PELICULA_BY_ID)) {
			st.setInt(1, idPelicula);
			try(ResultSet rs = st.executeQuery()){
				if (!rs.isBeforeFirst()) {
					return null;
				}
				rs.next();
				return crearPelicula(rs);
			}
		} catch (SQLException ex) {
			throw new DataAccessException("Error al recuperar todas las películas", ex);
		}
	}
	private static Pelicula crearPelicula(ResultSet rs) throws SQLException {
		Pelicula pelicula = new Pelicula(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
				rs.getInt("release_year"), rs.getString("language"));
		return pelicula;
	}
}
