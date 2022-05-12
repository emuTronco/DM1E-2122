package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos02layouts;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EjemploLayout04Grid {

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
		panelPpal.setLayout(new GridLayout(4, 4, 10, 10)); 
		ventana.setContentPane(panelPpal);

		// Creamos botones para añadirlos a la ventana. Usamos la clase JButton
		JButton btn1 = new JButton("Botón que no hace nada 1");
		panelPpal.add(btn1);
		JButton btn2 = new JButton("Botón que no hace nada 2");
		panelPpal.add(btn2);
		JButton btn3 = new JButton("Botón que no hace nada 3");
		panelPpal.add(btn3);
		JButton btn4 = new JButton("Botón que no hace nada 4");
		panelPpal.add(btn4);
		JButton btn5 = new JButton("Botón que no hace nada 5");
		panelPpal.add(btn5);
		panelPpal.add(new JButton("Otro botón"));
		panelPpal.add(new JButton("Otro botón"));
		panelPpal.add(new JButton("Otro botón"));
		panelPpal.add(new JButton("Otro botón"));
		panelPpal.add(new JButton("Otro botón"));
		panelPpal.add(new JButton("Otro botón"));
		panelPpal.add(new JButton("Otro botón"));
		panelPpal.add(new JButton("Otro botón"));
		panelPpal.add(new JButton("Otro botón"));

		// Mostramos la ventana. No usamos el método "show" que podéis ver en alguna
		// documentación porque se considera obsoleto.
		ventana.setVisible(true);
	}

}
