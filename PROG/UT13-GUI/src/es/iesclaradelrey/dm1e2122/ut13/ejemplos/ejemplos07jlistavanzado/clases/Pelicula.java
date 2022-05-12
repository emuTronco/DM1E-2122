package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado.clases;

public class Pelicula {
	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo + ", descripcion=" + descripcion
				+ ", anioEstreno=" + anioEstreno + ", idioma=" + idioma + "]";
	}

	private int idPelicula;
	private String titulo;
	private String descripcion;
	private int anioEstreno;
	private String idioma;

	public Pelicula(int idPelicula, String titulo, String descripcion, int anioEstreno, String idioma) {
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.anioEstreno = anioEstreno;
		this.idioma = idioma;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getAnioEstreno() {
		return anioEstreno;
	}

	public String getIdioma() {
		return idioma;
	}
}
