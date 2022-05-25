package org.lopezjoseluis.ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Programa {

	private JFrame frame;
	private JTextField textFieldAnimales;
	private JTextField textFieldNumero;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblAnimales = new JLabel("Animales");
		panel.add(lblAnimales);

		textFieldAnimales = new JTextField();
		panel.add(textFieldAnimales);
		textFieldAnimales.setColumns(10);

		JLabel lblNumero = new JLabel("Número");
		panel.add(lblNumero);

		textFieldNumero = new JTextField();
		panel.add(textFieldNumero);
		textFieldNumero.setColumns(10);

		JButton btnConstruirCancion = new JButton("New button");
		btnConstruirCancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int numero = Integer.parseInt(textFieldNumero.getText());

					String animales = textFieldAnimales.getText();
					if (animales == null || animales.length() == 0) {
						JOptionPane.showMessageDialog(btnConstruirCancion, "No se ha especificado el nombre de los animales",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(btnConstruirCancion, String.format("%d %s se balanceaban sobre la tela de una araña...", numero, animales),
								"Error", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnConstruirCancion, "Error al convertir el número de animales",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		frame.getContentPane().add(btnConstruirCancion, BorderLayout.SOUTH);
	}

}
