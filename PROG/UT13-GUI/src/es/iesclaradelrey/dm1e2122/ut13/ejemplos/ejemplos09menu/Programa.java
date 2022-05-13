package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos09menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class Programa {

	private JFrame frame;
	private final ButtonGroup buttonGroupMenuRadios = new ButtonGroup();

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

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnArchivo.add(mntmAbrir);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmExportar = new JMenuItem("Exportar");
		mntmExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClicMenuExportar();
			}

		});
		mnArchivo.add(mntmExportar);
		
		JMenu mnConEstado = new JMenu("Con estado anidados");
		menuBar.add(mnConEstado);
		
		JMenu mnCheckBox = new JMenu("CheckBox");
		mnConEstado.add(mnCheckBox);
		
		JCheckBoxMenuItem chckbxmntmOpcion1 = new JCheckBoxMenuItem("Opción 1");
		mnCheckBox.add(chckbxmntmOpcion1);
		
		JCheckBoxMenuItem chckbxmntmOpcion2 = new JCheckBoxMenuItem("Opción 2");
		mnCheckBox.add(chckbxmntmOpcion2);
		
		JMenu mnRadioButton = new JMenu("RadioButton");
		mnConEstado.add(mnRadioButton);
		
		JRadioButtonMenuItem rdbtnmntmOpcionA = new JRadioButtonMenuItem("Opción A");
		buttonGroupMenuRadios.add(rdbtnmntmOpcionA);
		mnRadioButton.add(rdbtnmntmOpcionA);
		
		JRadioButtonMenuItem rdbtnmntmOpcionB = new JRadioButtonMenuItem("Opción B");
		buttonGroupMenuRadios.add(rdbtnmntmOpcionB);
		mnRadioButton.add(rdbtnmntmOpcionB);
	}

	private void onClicMenuExportar() {
		JOptionPane.showMessageDialog(frame, "Se ha hecho clic en el menú exportar...", "Operación de menú", JOptionPane.INFORMATION_MESSAGE);
	}

}
