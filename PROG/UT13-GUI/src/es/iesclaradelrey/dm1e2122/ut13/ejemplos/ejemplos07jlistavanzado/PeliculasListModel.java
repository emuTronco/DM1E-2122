package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado;

import java.util.List;

import javax.swing.AbstractListModel;

public class PeliculasListModel<Pelicula> extends AbstractListModel<Pelicula> {

	private static final long serialVersionUID = 1L;

	private List<Pelicula> items;

	public PeliculasListModel(List<Pelicula> peliculas) {
		this.items = peliculas;
	}

	@Override
	public int getSize() {
		return items.size();
	}

	@Override
	public Pelicula getElementAt(int index) {
		return items.get(index);
	}
}
