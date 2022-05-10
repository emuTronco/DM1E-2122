package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos08jpanel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PanelPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				System.out.println("En componentShown.");
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				System.out.println("En componentHidden.");
			}
		});
		setLayout(new BorderLayout(10, 10));
		
		JLabel lblTituloPanelPrincipal = new JLabel("Panel principal");
		lblTituloPanelPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPanelPrincipal.setFont(new Font("FreeSans", Font.BOLD, 35));
		add(lblTituloPanelPrincipal, BorderLayout.NORTH);
		
		JButton btnAbrirDialogo = new JButton("Abrir diálogo con otro panel");
		add(btnAbrirDialogo, BorderLayout.SOUTH);
		btnAbrirDialogo.setBackground(Color.LIGHT_GRAY);
		btnAbrirDialogo.setForeground(Color.GRAY);
		
		JPanel panelCentral = new JPanel();
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JList listaPeliculas = new JList();
		panelCentral.add(listaPeliculas, BorderLayout.WEST);
		
		JPanel panelDatos = new JPanel();
		panelCentral.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.X_AXIS));

	}
}
