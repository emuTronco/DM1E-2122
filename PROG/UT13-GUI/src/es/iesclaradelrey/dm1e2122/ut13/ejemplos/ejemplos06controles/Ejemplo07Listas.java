package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos06controles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * Ejemplo de JList
 *
 */
public class Ejemplo07Listas extends JFrame {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "sakilauser";
	private static final String PASSWORD = "pwdsakilauser";

	private JPanel contentPane;
	private JList listPeliculas;
	private JTextField textFieldTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo07Listas frame = new Ejemplo07Listas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo07Listas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarDatosEnLista();
			}

		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPaneLista = new JScrollPane();
		contentPane.add(scrollPaneLista, BorderLayout.WEST);

		listPeliculas = new JList();
		listPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPeliculas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				actualizaCampoTexto(e);
			}
		});
		scrollPaneLista.setViewportView(listPeliculas);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setEditable(false);
		contentPane.add(textFieldTitulo, BorderLayout.CENTER);
		textFieldTitulo.setColumns(10);
	}

	private void cargarDatosEnLista() {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select title from film")) {
			List<String> titulos = new ArrayList<>();
			while (rs.next()) {
				titulos.add(rs.getString("title"));
			}

			listPeliculas.setListData(titulos.toArray());
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

	private void actualizaCampoTexto(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			String newValue = (String)listPeliculas.getSelectedValue();
			textFieldTitulo.setText(newValue);
		}
	}

}
