package es.iesclaradelrey.dm1e2122.ut13.ejercicios.ejercicio01;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ContadorPulsaciones01 extends JFrame {

	private JPanel contentPane;
	private JTextField textNormales;
	private JTextField textAlt;
	private JTextField textShift;
	private JTextField textControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContadorPulsaciones01 frame = new ContadorPulsaciones01();
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
	public ContadorPulsaciones01() {
		setTitle("Contador de pulsaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblInstrucciones = new JLabel("Escribe en la caja de texto y el sistema contará las pulsaciones.");
		lblInstrucciones.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblInstrucciones, BorderLayout.NORTH);

		JTextArea textAreaTexto = new JTextArea();
		textAreaTexto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				procesarTecla(e);
			}
		});
		textAreaTexto.setLineWrap(true);
		JScrollPane scrollPaneTexto = new JScrollPane(textAreaTexto);
		contentPane.add(scrollPaneTexto, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2, 6, 0, 0));

		JLabel lblNormales = new JLabel("Normal");
		lblNormales.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNormales);

		JLabel lblShift = new JLabel("Shift");
		lblShift.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblShift);

		JLabel lblControl = new JLabel("Control");
		lblControl.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblControl);

		JLabel lblAlt = new JLabel("Alt");
		lblAlt.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAlt);

		textNormales = new JTextField();
		lblNormales.setLabelFor(textNormales);
		textNormales.setText("0");
		textNormales.setEditable(false);
		textNormales.setFont(new Font("Dialog", Font.PLAIN, 25));
		textNormales.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textNormales);
		textNormales.setColumns(10);

		textShift = new JTextField();
		lblShift.setLabelFor(textShift);
		textShift.setText("0");
		textShift.setEditable(false);
		textShift.setFont(new Font("Dialog", Font.PLAIN, 25));
		textShift.setHorizontalAlignment(SwingConstants.CENTER);
		textShift.setColumns(10);
		panel.add(textShift);

		textControl = new JTextField();
		lblControl.setLabelFor(textControl);
		textControl.setText("0");
		textControl.setEditable(false);
		textControl.setFont(new Font("Dialog", Font.PLAIN, 25));
		textControl.setHorizontalAlignment(SwingConstants.CENTER);
		textControl.setColumns(10);
		panel.add(textControl);

		textAlt = new JTextField();
		lblAlt.setLabelFor(textAlt);
		textAlt.setText("0");
		textAlt.setEditable(false);
		textAlt.setFont(new Font("Dialog", Font.PLAIN, 25));
		textAlt.setHorizontalAlignment(SwingConstants.CENTER);
		textAlt.setColumns(10);
		panel.add(textAlt);
	}

	protected void procesarTecla(KeyEvent e) {
		boolean isSpecial = false;
		if (e.isAltDown()) {
			incrementarContador(textAlt);
			isSpecial = true;
		}
		if (e.isControlDown()) {
			incrementarContador(textControl);
			isSpecial = true;
		}
		if (e.isShiftDown()) {
			incrementarContador(textShift);
			isSpecial = true;
		}
		if (!isSpecial) {
			incrementarContador(textNormales);
		}
	}

	private void incrementarContador(JTextField textContador) {
		int actual = Integer.parseInt(textContador.getText());
		textContador.setText(Integer.toString(actual + 1));
	}

}
