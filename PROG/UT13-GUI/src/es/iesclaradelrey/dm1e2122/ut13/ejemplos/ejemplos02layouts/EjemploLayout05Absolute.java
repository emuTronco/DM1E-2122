package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos02layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EjemploLayout05Absolute {

	public static void main(String[] args) {

		// Creamos la ventana usando el constructor que nos permite asignar el título.
		JFrame ventana = new JFrame("JFrame con cosas.");

		// Damos un tamaño a la ventana, si no lo hacemos, no se vería más que un
		// cuadrado pequeño.
		ventana.setSize(800, 600);

		// Esto es necesario para que nuestra aplicación finalice. Si no, se quedará
		// ejecutándose aunque no haya ventanas visibles.
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Por defecto, cuando cerramos la ventana, se usa "HIDE_ON_CLOSE", quehace que
		// el objeto siga existiendo, aunque no esté visible.
		// Por defecto, la aplicación se cierra cuando todas las ventanas creadas se han
		// eliminado (dispose).

		// Creamos un panel para añadirlo al JFrame
		JPanel panelPpal = new JPanel();
		panelPpal.setLayout(null); // Si no ponemos Layout Manager, los componentes se posicionan de forma
									// absoluta.
		ventana.setContentPane(panelPpal);

		// Creamos botones para añadirlos a la ventana. Usamos la clase JButton
		JButton btn1 = new JButton("Botón que no hace nada 1");
		btn1.setBounds(10, 10, 310, 60);
		panelPpal.add(btn1);
		JButton btn2 = new JButton("Botón que no hace nada 2");
		btn2.setBounds(330, 10, 310, 60);
		panelPpal.add(btn2);
		JButton btn3 = new JButton("Botón que no hace nada 3");
		btn3.setBounds(10, 80, 310, 60);
		panelPpal.add(btn3);
		JButton btn4 = new JButton("Botón que no hace nada 4");
		btn4.setBounds(330, 80, 310, 60);
		panelPpal.add(btn4);
		

		// Mostramos la ventana. No usamos el método "show" que podéis ver en alguna
		// documentación porque se considera obsoleto.
		ventana.setVisible(true);
	}

}
