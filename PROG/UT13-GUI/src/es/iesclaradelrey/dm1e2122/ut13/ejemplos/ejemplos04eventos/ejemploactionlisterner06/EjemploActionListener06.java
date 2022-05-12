package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos04eventos.ejemploactionlisterner06;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * Ejemplo en el que se usan clases adaptadoras para no tener que implementar
 * todos los métodos de una interfaz cuando queremos usar sólo un método del
 * mismo.
 *
 */
public class EjemploActionListener06 implements ActionListener {

	private JFrame frame;
	private JButton btnEscribeConsola01;
	private JButton btnEscribeConsola02;
	private JButton btnEscribeConsola03;
	private JButton btnEscribeConsola04;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploActionListener06 window = new EjemploActionListener06();
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
	public EjemploActionListener06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Entrando en la zona");
				btnEscribeConsola04.setBackground(new Color(255, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Saliendo de la zona");
				btnEscribeConsola04.setBackground(new Color(0, 255, 0));
			}
		});
		frame.setBounds(100, 100, 454, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnEscribeConsola01 = new JButton("Escribe la hora por consola (1)");
		btnEscribeConsola01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cambiarColorBoton((JButton) e.getSource(), 255, 0, 0);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambiarColorBoton((JButton) e.getSource(), 0, 255, 0);
			}
		});

		btnEscribeConsola01.addActionListener(this);

		btnEscribeConsola01.setBounds(69, 28, 283, 81);
		frame.getContentPane().add(btnEscribeConsola01);

		btnEscribeConsola02 = new JButton("Escribe la hora por consola (2)");
		btnEscribeConsola02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cambiarColorBoton((JButton) e.getSource(), 255, 0, 0);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambiarColorBoton((JButton) e.getSource(), 0, 0, 255);
			}
		});

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

		btnEscribeConsola04 = new JButton("Escribe la hora por consola (4)");
		btnEscribeConsola04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.printf("Hora según botón 4: %s\n", LocalDateTime.now().toString());

			}
		});
		btnEscribeConsola04.setBounds(69, 350, 283, 81);
		frame.getContentPane().add(btnEscribeConsola04);

		textField = new JTextField();
		textField.setBounds(60, 211, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	private void cambiarColorBoton(JButton source, int r, int g, int b) {
		source.setBackground(new Color(r, g, b));
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
