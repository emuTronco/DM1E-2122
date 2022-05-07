package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos04eventos.ejemploactionlisterner03;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * Ejemplo en el que la propia clase hace la implementación de actionListener, y
 * en el método comprobamos usando getSource() qué componente ha disparado el
 * evento. Problema: El código del método (handler) se vuelve más complejo con el tiempo.
 *
 */
public class EjemploActionListener03 implements ActionListener {

	private JFrame frame;
	private JButton btnEscribeConsola01;
	private JButton btnEscribeConsola02;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploActionListener03 window = new EjemploActionListener03();
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
	public EjemploActionListener03() {
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

		btnEscribeConsola01 = new JButton("Escribe la hora por consola (1)");

		btnEscribeConsola01.addActionListener(this);

		btnEscribeConsola01.setBounds(69, 28, 283, 81);
		frame.getContentPane().add(btnEscribeConsola01);

		btnEscribeConsola02 = new JButton("Escribe la hora por consola (2)");

		btnEscribeConsola02.addActionListener(this);

		btnEscribeConsola02.setBounds(69, 135, 283, 81);
		frame.getContentPane().add(btnEscribeConsola02);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnEscribeConsola01) {
			System.out.printf("Hora según botón 1: %s\n", LocalDateTime.now().toString());
		}
		if (e.getSource() == this.btnEscribeConsola02) {
			System.out.printf("Hora según botón 2: %s\n", LocalDateTime.now().toString());
		}
	}
}
