package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos08dialogos.jdialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Programa {

	private JFrame frmPruebaDeDilogo;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa window = new Programa();
					window.frmPruebaDeDilogo.setVisible(true);
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
		frmPruebaDeDilogo = new JFrame();
		frmPruebaDeDilogo.setTitle("Prueba de diálogo");
		frmPruebaDeDilogo.setBounds(100, 100, 678, 300);
		frmPruebaDeDilogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblInstrucciones = new JLabel(
				"<html>Pulsar en el botón \"Abrir diálogo\" para probar el diálogo a medida. <br/>Al cerrar el diálogo se mostrará el resultado en el centro de esta ventana.</html>");
		lblInstrucciones.setHorizontalAlignment(SwingConstants.CENTER);
		frmPruebaDeDilogo.getContentPane().add(lblInstrucciones, BorderLayout.NORTH);

		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		frmPruebaDeDilogo.getContentPane().add(lblResultado, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frmPruebaDeDilogo.getContentPane().add(panel, BorderLayout.SOUTH);
		
				JButton btnAbrirDialogo = new JButton("Abrir diálogo (modal)");
				panel.add(btnAbrirDialogo);
				
				JButton btnAbrirDialogoNoModal = new JButton("Abrir diálogo (no modal)");
				btnAbrirDialogoNoModal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abrirDialogoDatosPersonales(false);
					}
				});
				panel.add(btnAbrirDialogoNoModal);
				btnAbrirDialogo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abrirDialogoDatosPersonales(true);
					}
				});
	}

	private void abrirDialogoDatosPersonales(boolean modal) {
		// Creamos el diálogo
		DatosPersonalesDialog dialogoModal = new DatosPersonalesDialog(this.frmPruebaDeDilogo, modal);

		// Lo hacemos visible
		dialogoModal.setVisible(true);

		// Al ser modal, la llamada a setVisible(true) se queda bloqueada hasta
		// que el dialogo modal se oculte. A continuación, con el diálogo ya invisible,
		// podemos pedirle los datos
		DatosPersonales datos = dialogoModal.getDatosPersonales();
		if (datos == null) {
			this.lblResultado.setText("Se ha cancelado el diálogo");
		} else {
			this.lblResultado.setText(datos.toString());
		}
	}
}
