package es.iesclaradelrey.ut92.sax.ejemplo02;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxEjemplo02Handler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inicio del documento.");
	}

	@Override

	public void endDocument() throws SAXException {
		System.out.println("Fin del documento.");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.printf("Inicio de elemento %s\n", qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.printf("Fin de elemento %s\n", qName);
	}
}
