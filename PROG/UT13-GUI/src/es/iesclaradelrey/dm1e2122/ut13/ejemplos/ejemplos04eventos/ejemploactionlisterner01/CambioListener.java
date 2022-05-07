package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos04eventos.ejemploactionlisterner01;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CambioListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println("En el listener para stateChanged");
	}

}
