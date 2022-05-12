package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos06controles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ejemplo05LabelYTexto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textFieldApellidos;
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo05LabelYTexto frame = new Ejemplo05LabelYTexto();
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
	public Ejemplo05LabelYTexto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		JLabel lblIntro = new JLabel("Etiqueta JLabel que puedo usar para texto");
		lblIntro.setFont(new Font("Chilanka", Font.BOLD, 20));
		contentPane.add(lblIntro, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 10, 10));
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setText("<html>Hola<strong> José</strong></html>");
		textFieldApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("Se ha pulsado la tecla " + e.getKeyChar());
			}
		});
		lblApellidos.setLabelFor(textFieldApellidos);
		panel.add(textFieldApellidos);
		textFieldApellidos.setColumns(8);
		
		JLabel lblNombre = new JLabel("<html>N<em>omb</em>re:<br>Otra l&iacute;nea HTML</html>");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				informaDePulsacion(e);
			}

		});
		textFieldNombre.setToolTipText("Nombre");
		lblNombre.setLabelFor(textFieldNombre);
		textFieldNombre.setColumns(8);
		panel.add(textFieldNombre);
		
		JButton btnAceptar = new JButton("Aceptar");
		contentPane.add(btnAceptar, BorderLayout.SOUTH);
	}

	private void informaDePulsacion(KeyEvent e) {
		System.out.println("Se ha pulsado la tecla con código " + e.getKeyCode());
	}

}
