package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos04eventos.ejemploactionlisterner05;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * Ejemplo en el que aprovechamos que ActionListener es una interfaz funcional
 * (sólo un método abstracto) para usar una expresión lambda.
 *
 */
public class EjemploActionListener05 implements ActionListener {

	private JFrame frame;
	private JButton btnEscribeConsola01;
	private JButton btnEscribeConsola02;
	private JButton btnEscribeConsola03;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploActionListener05 window = new EjemploActionListener05();
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
	public EjemploActionListener05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnEscribeConsola01 = new JButton("Escribe la hora por consola (1)");

		btnEscribeConsola01.addActionListener(this);

		btnEscribeConsola01.setBounds(69, 28, 283, 81);
		frame.getContentPane().add(btnEscribeConsola01);

		btnEscribeConsola02 = new JButton("Escribe la hora por consola (2)");

		btnEscribeConsola02.addActionListener(this);

		btnEscribeConsola02.setBounds(69, 138, 283, 81);
		frame.getContentPane().add(btnEscribeConsola02);

		btnEscribeConsola03 = new JButton("Escribe la hora por consola (3)");

		btnEscribeConsola03.addActionListener((e) -> {
			// Implementación del único método de la interfaz funcional
			System.out.printf("Hora según botón 3: %s\n", LocalDateTime.now().toString());
		});

		btnEscribeConsola03.setBounds(69, 255, 283, 81);
		frame.getContentPane().add(btnEscribeConsola03);
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
