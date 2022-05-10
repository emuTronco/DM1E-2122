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
 * Ejemplo de uso de Button.setActionCommand() y ActionEvent.getActionCommand()
 * para distinguir el componente que dispara el evento.
 *
 */
public class Ejemplo02Botones extends JFrame {

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
					Ejemplo02Botones frame = new Ejemplo02Botones();
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
	public Ejemplo02Botones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		btnUno = new JButton("Botón 1");
		btnUno.setActionCommand("uno");
		contentPane.add(btnUno);

		btnDos = new JButton("Botón 2");
		btnDos.setActionCommand("dos");
		contentPane.add(btnDos);

		btnTres = new JButton("Botón 3");
		btnTres.setActionCommand("tres");
		contentPane.add(btnTres);

		// Listener común a todos los botones.
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				switch (actionCommand) {
				case "uno":
					System.out.println("Pulsado botón 1");
					break;
				case "dos":
					System.out.println("Pulsado botón 2");
					break;
				case "tres":
					System.out.println("Pulsado botón 3");
					break;
				}
			}
		};
		
		btnUno.addActionListener(listener);
		btnDos.addActionListener(listener);
		btnTres.addActionListener(listener);

	}

}
