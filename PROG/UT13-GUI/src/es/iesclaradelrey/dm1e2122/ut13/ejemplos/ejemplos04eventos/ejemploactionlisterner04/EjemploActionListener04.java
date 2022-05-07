package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos04eventos.ejemploactionlisterner04;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * Ejemplo con el comportamiento por defecto en Eclipse y la mayoría de IDE. Se
 * usa un objeto de una clase anónima que implementa el interfaz. Se crea con la
 * sintaxis: .addXyzListener(new XyzListener() { public void
 * eventoEjecutado(XyzEvent e) { // Cñodigo } });
 *
 */
public class EjemploActionListener04 implements ActionListener {

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
					EjemploActionListener04 window = new EjemploActionListener04();
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
	public EjemploActionListener04() {
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

		btnEscribeConsola03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.printf("Hora según botón 3: %s\n", LocalDateTime.now().toString());
			}
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
