package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado.clases.Pelicula;
import es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado.data.DataAccess;

public class Programa {

	private JFrame frame;
	private JList<Pelicula> listPeliculas;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa window = new Programa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Programa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarListaPeliculas();
			}

		});
		frame.setBounds(100, 100, 865, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPanePeliculas = new JScrollPane();
		frame.getContentPane().add(scrollPanePeliculas, BorderLayout.WEST);

		listPeliculas = new JList<>();
		listPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPeliculas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				mostrarDatosPelicula(e);
			}
		});
		scrollPanePeliculas.setViewportView(listPeliculas);

		JPanel panelDetallesPelicula = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelDetallesPelicula.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panelDetallesPelicula, BorderLayout.CENTER);
		
		lblId = new JLabel("Id");
		panelDetallesPelicula.add(lblId);
	}

	private void cargarListaPeliculas() {
		List<Pelicula> peliculas = DataAccess.getAllPeliculas();
		listPeliculas.setCellRenderer(new PeliculaListCellRenderer());
		listPeliculas.setModel(new PeliculasListModel<>(peliculas));
	}

	private void mostrarDatosPelicula(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			Pelicula peliculaSeleccionada = listPeliculas.getSelectedValue();
			mostrarDatosPelicula(peliculaSeleccionada);
		}
	}

	private void mostrarDatosPelicula(Pelicula peliculaSeleccionada) {
		System.out.println("Seleccionada: " + peliculaSeleccionada);

	}
}
