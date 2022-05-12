package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos06controles;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * Ejemplo de checkboxes y evento ItemEvent
 *
 */
public class Ejemplo03CheckBoxes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo03CheckBoxes frame = new Ejemplo03CheckBoxes();
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
	public Ejemplo03CheckBoxes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JCheckBox chckbxUno = new JCheckBox("Opción 1");
		JCheckBox chckbxDos = new JCheckBox("Opcion 2");
		JCheckBox chckbxTres = new JCheckBox("Opción 3");
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(chckbxUno);
		contentPane.add(chckbxDos);
		contentPane.add(chckbxTres);

		ItemListener listener = new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nuevoEstado = (e.getStateChange() == ItemEvent.SELECTED) ? "SELECTED" : "DESELECTED";
				System.out.println("Ha cambiado el estado del checkbox. Ha pasado a " + nuevoEstado);
			}
		};
		
		chckbxUno.addItemListener(listener);
		chckbxDos.addItemListener(listener);
		chckbxTres.addItemListener(listener);
	}
}
