package es.iesclaradelrey.dm1e2122.ut13.ejercicios.ejercicio02y03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SelectorColor02 extends JFrame {

	private JPanel contentPane;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;
	private JTextField textRed;
	private JTextField textGreen;
	private JTextField textBlue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectorColor02 frame = new SelectorColor02();
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
	public SelectorColor02() {
		setTitle("Selector de colores");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				initSliders();
			}

		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 25, 25));

		sliderRed = new JSlider();
		sliderRed.setToolTipText("Rojo");
		sliderRed.setMinorTickSpacing(5);
		sliderRed.setMajorTickSpacing(255);
		sliderRed.setSnapToTicks(true);
		sliderRed.setPaintTicks(true);
		sliderRed.setPaintLabels(true);
		contentPane.add(sliderRed);
		sliderRed.setMaximum(255);

		textRed = new JTextField();
		textRed.setForeground(Color.WHITE);
		textRed.setText("0");
		textRed.setBackground(Color.RED);
		textRed.setHorizontalAlignment(SwingConstants.CENTER);
		textRed.setFont(new Font("Dialog", Font.PLAIN, 25));
		contentPane.add(textRed);
		textRed.setColumns(10);

		sliderGreen = new JSlider();
		sliderGreen.setToolTipText("Verde");
		sliderGreen.setMinorTickSpacing(5);
		sliderGreen.setMajorTickSpacing(255);
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		contentPane.add(sliderGreen);
		sliderGreen.setMaximum(255);

		textGreen = new JTextField();
		textGreen.setText("0");
		textGreen.setBackground(Color.GREEN);
		textGreen.setHorizontalAlignment(SwingConstants.CENTER);
		textGreen.setFont(new Font("Dialog", Font.PLAIN, 25));
		textGreen.setColumns(10);
		contentPane.add(textGreen);

		sliderBlue = new JSlider();
		sliderBlue.setToolTipText("Azul");
		sliderBlue.setMinorTickSpacing(5);
		sliderBlue.setMajorTickSpacing(255);
		sliderBlue.setSnapToTicks(true);
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		contentPane.add(sliderBlue);
		sliderBlue.setMaximum(255);

		textBlue = new JTextField();
		textBlue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				actualizaSlider();
			}
		});
		textBlue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizaSlider();
			}

		});
		textBlue.setForeground(Color.WHITE);
		textBlue.setText("0");
		textBlue.setBackground(Color.BLUE);
		textBlue.setHorizontalAlignment(SwingConstants.CENTER);
		textBlue.setFont(new Font("Dialog", Font.PLAIN, 25));
		textBlue.setColumns(10);
		contentPane.add(textBlue);

		sliderRed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ajustarColorPanel();
			}
		});

		sliderGreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ajustarColorPanel();
			}
		});

		sliderBlue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ajustarColorPanel();
			}
		});

		this.pack();
	}

	private void initSliders() {
		sliderRed.setValue(0);
		sliderGreen.setValue(0);
		sliderBlue.setValue(0);

		ajustarColorPanel();
	}

	private void ajustarColorPanel() {
		int r = sliderRed.getValue();
		int g = sliderGreen.getValue();
		int b = sliderBlue.getValue();

		textRed.setText(Integer.toString(r));
		textGreen.setText(Integer.toString(g));
		textBlue.setText(Integer.toString(b));

		contentPane.setBackground(new Color(r, g, b));
	}

	private void actualizaSlider() {
		try {
			sliderBlue.setValue((int) Double.parseDouble(textBlue.getText()));
			System.out.println("En textBlue.keyTyped");
		} catch (Exception ex) {
			sliderBlue.setValue(0);
		}
	}
}
