package es.iesclaradelrey.dm1e2122.ut13.ejercicios.ejercicio02y03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SelectorColor01 extends JFrame {

	private JPanel contentPane;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectorColor01 frame = new SelectorColor01();
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
	public SelectorColor01() {
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
		contentPane.setLayout(new GridLayout(3, 1, 25, 25));

		sliderRed = new JSlider();
		sliderRed.setToolTipText("Rojo");
		sliderRed.setMinorTickSpacing(5);
		sliderRed.setMajorTickSpacing(255);
		sliderRed.setSnapToTicks(true);
		sliderRed.setPaintTicks(true);
		sliderRed.setPaintLabels(true);
		contentPane.add(sliderRed);
		sliderRed.setMaximum(255);

		sliderGreen = new JSlider();
		sliderGreen.setToolTipText("Verde");
		sliderGreen.setMinorTickSpacing(5);
		sliderGreen.setMajorTickSpacing(255);
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		contentPane.add(sliderGreen);
		sliderGreen.setMaximum(255);

		sliderBlue = new JSlider();
		sliderBlue.setToolTipText("Azul");
		sliderBlue.setMinorTickSpacing(5);
		sliderBlue.setMajorTickSpacing(255);
		sliderBlue.setSnapToTicks(true);
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		contentPane.add(sliderBlue);
		sliderBlue.setMaximum(255);

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
		sliderRed.setValue(255);
		sliderGreen.setValue(255);
		sliderBlue.setValue(255);

		ajustarColorPanel();
	}

	private void ajustarColorPanel() {
		int r = sliderRed.getValue();
		int g = sliderGreen.getValue();
		int b = sliderBlue.getValue();

		contentPane.setBackground(new Color(r, g, b));
	}
}
