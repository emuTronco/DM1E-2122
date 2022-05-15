package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos08dialogos.basicos;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Basico01Mensaje {

	public static void main(String[] args) {

//		JOptionPane.showMessageDialog(null, "El mensaje más básico");
//		
//		JOptionPane.showMessageDialog(null, "El mensaje con título", "Título de la ventana", JOptionPane.ERROR_MESSAGE);
//		
//		JOptionPane.showMessageDialog(null, "Más completo", "Título", JOptionPane.WARNING_MESSAGE, new ImageIcon("src/es/iesclaradelrey/dm1e2122/ut13/ejemplos/ejemplos08dialogos/demosoracle/images/green.gif"));
//		

		int valorRetorno = JOptionPane.showConfirmDialog(null, "El mensaje más básico"); // Por defcto 3 botones
		System.out.println(valorRetorno);
		if (valorRetorno == JOptionPane.YES_OPTION) {
			System.out.println("Ha pulsado en Sí");
		}
		if (valorRetorno == JOptionPane.NO_OPTION) {
			System.out.println("Ha pulsado en No");
		}
		if (valorRetorno == JOptionPane.CANCEL_OPTION) {
			System.out.println("Ha pulsado en Cancelar");
		}
//
//		
//		valorRetorno = JOptionPane.showConfirmDialog(null, "El mensaje", "Titulo", JOptionPane.WARNING_MESSAGE); // Por defcto 3 botones

//		String valorIntroducido = JOptionPane.showInputDialog("Introduce un número");
//		System.out.println(valorIntroducido);

		Object[] valores = { "", "Opcion 1", "Opcion 2", "Opcion 3" };
		
		String valorIntroducido2 = (String)JOptionPane.showInputDialog(null, "Elige", "Titulo", JOptionPane.ERROR_MESSAGE, null, valores, null );
		System.out.println(valorIntroducido2);

	}

}
