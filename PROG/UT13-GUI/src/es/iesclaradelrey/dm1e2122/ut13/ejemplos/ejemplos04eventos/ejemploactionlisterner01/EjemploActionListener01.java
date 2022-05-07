package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos04eventos.ejemploactionlisterner01;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * Ejemplo en el que el listener se crea usando una clase que implementa
 * ActionListener Problema: hay que crear una clase para cada botón, o para cada
 * evento que queramos atender.
 *
 */
public class EjemploActionListener01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploActionListener01 window = new EjemploActionListener01();
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
	public EjemploActionListener01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnEscribeConsola = new JButton("Escribe la hora por consola");

		btnEscribeConsola.addActionListener(new EscribeHoraConsolaActionListener());

		btnEscribeConsola.addChangeListener(new CambioListener());

		btnEscribeConsola.setBounds(105, 81, 247, 81);
		frame.getContentPane().add(btnEscribeConsola);
	}
}
