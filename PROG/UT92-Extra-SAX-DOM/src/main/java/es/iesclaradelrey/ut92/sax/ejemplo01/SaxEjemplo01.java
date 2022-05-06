package es.iesclaradelrey.ut92.sax.ejemplo01;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxEjemplo01 {

	private static final String PATH_XML = "FicherosXML" + File.separator + "ClientesYPedidos.xml";

	public static void main(String[] args) {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			SaxEjemplo01Handler saxHandler = new SaxEjemplo01Handler();
			saxParser.parse(PATH_XML, saxHandler);
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
