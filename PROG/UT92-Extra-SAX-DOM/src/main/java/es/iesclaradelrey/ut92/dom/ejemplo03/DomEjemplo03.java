package es.iesclaradelrey.ut92.dom.ejemplo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomEjemplo03 {

	private static final String PATH_XML_LECTURA = "FicherosXML" + File.separator + "ClientesYPedidos.xml";
	private static final String PATH_XML_SALIDA = "FicherosXML" + File.separator + "ClientesYPedidosModificado.xml";

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(PATH_XML_LECTURA);
			System.out.println("Vamos a buscar el cliente que tenga el ID 'GREAL'.");
			Node nodoCliente = buscarCliente(doc, "GREAL");
			if (nodoCliente == null) {
				System.out.println("No se ha encontrado el cliente con el ID 'GREAL'");
			} else {
				System.out.println("Encontrado el cliente con el ID 'GREAL'");
				// Modificamos el cliente.
				Node elementoNuevo = doc.createElement("Modified");
				elementoNuevo.setTextContent("Yes");
				nodoCliente.appendChild(elementoNuevo);

				// Guardamos el documento en otro fichero.
				guardarDocumento(doc, PATH_XML_SALIDA);

				System.out.println("Fichero guardado...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void guardarDocumento(Document doc, String pathXmlSalida) {
		Transformer transformer;
		try {
			PrintWriter pw = new PrintWriter(pathXmlSalida); 
//			StringWriter sw = new StringWriter();
			transformer = TransformerFactory.newInstance().newTransformer();
			Result output = new StreamResult(pw);
			Source input = new DOMSource(doc);
			transformer.transform(input, output);

		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Node buscarCliente(Document doc, String idCliente) {
		NodeList clientes = doc.getElementsByTagName("Customer");
		for (int i = 0; i < clientes.getLength(); i++) {
			Node n = clientes.item(i);
			if (tieneAtributo(n, "CustomerID", idCliente))
				return n;
		}
		return null;
	}

	private static boolean tieneAtributo(Node n, String nombreAtributo, String valorAtributo) {
		Node atributo = n.getAttributes().getNamedItem(nombreAtributo);
		if (atributo != null) {
			if (atributo.getNodeValue().equals(valorAtributo)) {
				return true;
			}
		}
		return false;
	}

}
