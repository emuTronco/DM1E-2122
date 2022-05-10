package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos05calculadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculadora {

	private JFrame frame;
	private JTextField textResultado;
	private JTextField textOperandoA;
	private JTextField textOperandoB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 703, 265);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(10, 10));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panelOperandos = new JPanel();
		panel.add(panelOperandos, BorderLayout.NORTH);
		panelOperandos.setLayout(new GridLayout(1, 2, 10, 10));

		textOperandoA = new JTextField();
		textOperandoA.setHorizontalAlignment(SwingConstants.CENTER);
		textOperandoA.setFont(new Font("Dialog", Font.PLAIN, 35));
		panelOperandos.add(textOperandoA);
		textOperandoA.setColumns(10);

		textOperandoB = new JTextField();
		textOperandoB.setHorizontalAlignment(SwingConstants.CENTER);
		textOperandoB.setFont(new Font("Dialog", Font.PLAIN, 35));
		panelOperandos.add(textOperandoB);
		textOperandoB.setColumns(10);

		JPanel panelOperaciones = new JPanel();
		panel.add(panelOperaciones, BorderLayout.CENTER);
		panelOperaciones.setLayout(new GridLayout(1, 4, 10, 10));

		JButton btnSumar = new JButton("+");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumaNumeros();
			}
		});
		panelOperaciones.add(btnSumar);

		JButton btnRestar = new JButton("-");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restaNumeros();
			}
		});
		panelOperaciones.add(btnRestar);

		JButton btnMultiplicar = new JButton("X");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiplicaNumeros();
			}
		});
		panelOperaciones.add(btnMultiplicar);

		JButton btnDividir = new JButton("/");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				divideNumeros();
			}
		});
		panelOperaciones.add(btnDividir);

		textResultado = new JTextField();
		panel.add(textResultado, BorderLayout.SOUTH);
		textResultado.setHorizontalAlignment(SwingConstants.CENTER);
		textResultado.setFont(new Font("Dialog", Font.PLAIN, 35));
		textResultado.setColumns(10);
	}

	private void sumaNumeros() {
		double numA = Double.parseDouble(textOperandoA.getText());
		double numB = Double.parseDouble(textOperandoB.getText());
		textResultado.setText(Double.toString(numA + numB));
	}

	private void restaNumeros() {
		double numA = Double.parseDouble(textOperandoA.getText());
		double numB = Double.parseDouble(textOperandoB.getText());
		textResultado.setText(Double.toString(numA - numB));
	}
	private void multiplicaNumeros() {
		double numA = Double.parseDouble(textOperandoA.getText());
		double numB = Double.parseDouble(textOperandoB.getText());
		textResultado.setText(Double.toString(numA * numB));
	}
	private void divideNumeros() {
		double numA = Double.parseDouble(textOperandoA.getText());
		double numB = Double.parseDouble(textOperandoB.getText());
		textResultado.setText(Double.toString(numA / numB));
	}
}
