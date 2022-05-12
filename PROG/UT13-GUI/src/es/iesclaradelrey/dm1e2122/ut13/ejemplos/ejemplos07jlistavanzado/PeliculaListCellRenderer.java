package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado.clases.Pelicula;

public class PeliculaListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if (renderer instanceof JLabel && value instanceof Pelicula) {
			Pelicula p = (Pelicula) value;
			JLabel l = (JLabel) renderer;
//			ImageIcon icon = new ImageIcon("imagenes" + File.separator + "avatar.jpg");
//			
//			l.setIcon(icon);
//			l.setBounds(0, 0, 100, 100);
//			l.setText("");
			l.setText(p.getIdPelicula() + "-" + p.getTitulo());
			if (p.getTitulo().toLowerCase().contains("de")) {
				l.setForeground(new Color(255, 0, 0));
			}
		}
		return renderer;
	}
}
