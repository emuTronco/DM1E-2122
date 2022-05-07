package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos04eventos.ejemploactionlisterner02;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * Ejemplo en el que la propia clase hace la implementación de actionListener
 * Problema: Sólo tenemos un método que implementa ActionListener, por lo que
 * tendremos que apañarnoslas si tenemos que atender a más de un método.
 *
 */
public class EjemploActionListener02 implements ActionListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploActionListener02 window = new EjemploActionListener02();
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
	public EjemploActionListener02() {
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

		btnEscribeConsola.addActionListener(this);

		btnEscribeConsola.setBounds(105, 81, 247, 81);
		frame.getContentPane().add(btnEscribeConsola);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(LocalDateTime.now().toString());
	}
}
