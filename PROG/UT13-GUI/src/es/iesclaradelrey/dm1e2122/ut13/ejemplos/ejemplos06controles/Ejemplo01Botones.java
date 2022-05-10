package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos06controles;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * Ejemplo de uso de ActionEvent.getSource() para distinguir el componente que
 * dispara el evento.
 *
 */
public class Ejemplo01Botones extends JFrame {

	private JPanel contentPane;
	private JButton btnUno;
	private JButton btnDos;
	private JButton btnTres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo01Botones frame = new Ejemplo01Botones();
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
	public Ejemplo01Botones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		btnUno = new JButton("Botón 1");
		contentPane.add(btnUno);

		btnDos = new JButton("Botón 2");
		contentPane.add(btnDos);

		btnTres = new JButton("Botón 3");
		contentPane.add(btnTres);

		// Listener común a todos los botones.
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object boton = e.getSource();
				if (boton == btnUno) {
					System.out.println("Pulsado botón 1");
				}
				if (boton == btnDos) {
					System.out.println("Pulsado botón 2");
				}
				if (boton == btnTres) {
					System.out.println("Pulsado botón 3");
				}
			}
		};
		btnUno.addActionListener(listener);
		btnDos.addActionListener(listener);
		btnTres.addActionListener(listener);

	}

}
