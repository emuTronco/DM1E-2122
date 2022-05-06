package es.iesclaradelrey.ut92.dom.ejemplo01;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DomEjemplo01 {

	private static final String PATH_XML_LECTURA = "FicherosXML" + File.separator + "ClientesYPedidos.xml";

	public static void main(String[] args) {
		try {
			  DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			  Document doc = docBuilder.parse(PATH_XML_LECTURA);
			  NodeList nodos = doc.getElementsByTagName("City");
			  System.out.printf("En el XML hay %d elementos con la etiqueta 'City'", nodos.getLength());
			  
			} catch(Exception e) {
			  e.printStackTrace();
			}

	}

}
