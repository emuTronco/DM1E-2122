package es.iesclaradelrey.ut92.sax.ejemplo01;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxEjemplo01Handler extends DefaultHandler {
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inicio del documento.");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Fin del documento.");
	}
}
