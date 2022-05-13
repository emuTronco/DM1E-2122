package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos08dialogos.jdialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class DatosPersonalesDialog extends JDialog {

	// Propiedad para guardar los datos que vamos a solicitar al usuario.
	// Se inicializan a null porque no les daresmos valor si el usuario cancela el
	// diálogo
	private DatosPersonales datosPersonales = null;

	// Getter para poder consultar los datos desde fuera del diálogo:
	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textFechaNacimiento;

	/**
	 * Create the dialog.
	 */
	public DatosPersonalesDialog(Frame padre, boolean modal) {
		super(padre, modal); // Pasamos el padre y decimos que es modal.
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 450, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(3, 2, 10, 10));
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPanel.add(lblNombre);
		textNombre = new JTextField();
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPanel.add(lblApellidos);
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		contentPanel.add(textApellidos);
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPanel.add(lblFechaNacimiento);
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setColumns(10);
		contentPanel.add(textFechaNacimiento);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("Aceptar");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		buttonPane.add(cancelButton);

	}

	private void aceptar() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.datosPersonales = new DatosPersonales(this.textNombre.getText(), this.textApellidos.getText(),
				LocalDate.parse(this.textFechaNacimiento.getText(), dateFormat));
		setVisible(false);

	}

	private void cancelar() {
		this.datosPersonales = null;
		setVisible(false);
	}

}
