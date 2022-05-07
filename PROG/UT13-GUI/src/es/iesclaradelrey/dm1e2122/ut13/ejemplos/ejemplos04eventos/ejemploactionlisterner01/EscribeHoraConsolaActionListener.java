package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos04eventos.ejemploactionlisterner01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class EscribeHoraConsolaActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(LocalDateTime.now().toString());
	}

}

