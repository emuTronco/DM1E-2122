package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos06controles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo04RadioButtons extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupABCD = new ButtonGroup();
	private final ButtonGroup buttonGroupWXYZ = new ButtonGroup();
	private final ButtonGroup buttonGroupJK = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo04RadioButtons frame = new Ejemplo04RadioButtons();
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
	public Ejemplo04RadioButtons() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdbtnOpcionA = new JRadioButton("Opcion A");
		buttonGroupABCD.add(rdbtnOpcionA);
		contentPane.add(rdbtnOpcionA);
		
		JRadioButton rdbtnOpcionW = new JRadioButton("Opcion W");
		buttonGroupWXYZ.add(rdbtnOpcionW);
		contentPane.add(rdbtnOpcionW);
		
		JRadioButton rdbtnOpcionB = new JRadioButton("Opcion B");
		buttonGroupABCD.add(rdbtnOpcionB);
		contentPane.add(rdbtnOpcionB);
		
		JRadioButton rdbtnOpcionX = new JRadioButton("Opcion X");
		buttonGroupWXYZ.add(rdbtnOpcionX);
		contentPane.add(rdbtnOpcionX);
		
		JRadioButton rdbtnOpcionC = new JRadioButton("Opcion C");
		buttonGroupABCD.add(rdbtnOpcionC);
		contentPane.add(rdbtnOpcionC);
		
		JRadioButton rdbtnOpcionY = new JRadioButton("Opcion Y");
		buttonGroupWXYZ.add(rdbtnOpcionY);
		contentPane.add(rdbtnOpcionY);
		
		JRadioButton rdbtnOpcionD = new JRadioButton("Opcion D");
		buttonGroupABCD.add(rdbtnOpcionD);
		contentPane.add(rdbtnOpcionD);
		
		JRadioButton rdbtnOpcionZ = new JRadioButton("Opcion Z");
		buttonGroupWXYZ.add(rdbtnOpcionZ);
		contentPane.add(rdbtnOpcionZ);
		
		ActionListener actionJK = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("En clic de J o de K");
			}
		};
		
		JRadioButton rdbtnOpcionJ = new JRadioButton("Opción J");
		rdbtnOpcionJ.addActionListener(actionJK);
		buttonGroupJK.add(rdbtnOpcionJ);
		contentPane.add(rdbtnOpcionJ);
		
		JRadioButton rdbtnOpcionK = new JRadioButton("Opción K");
		rdbtnOpcionK.addActionListener(actionJK);
		buttonGroupJK.add(rdbtnOpcionK);
		contentPane.add(rdbtnOpcionK);
	}

}
