package es.iesclaradelrey.ut91.saxon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;;

/**
 * 
 * Clase que realiza una transformación XSLT de un XML para convertirlo a un
 * fichero HTML. Usa ficheros ubicados en la carpeta "ficheros/pruebaxslt" del
 * proyecto
 *
 */
public class PruebaXslt {

	private static final String XML = "ficheros" + File.separator + "pruebaxslt" + File.separator + "entrada.xml";
	private static final String XSLT = "ficheros" + File.separator + "pruebaxslt" + File.separator + "plantilla.xsl";
	private static final String HTML = "ficheros" + File.separator + "pruebaxslt" + File.separator + "salida.html";

	public static void main(String[] args) throws FileNotFoundException, IOException, TransformerException {
		System.out.println("Realizando transformación XSLT...");
		
		// Configuramos el sistema de transformaciones XSLT de Java para que use
		// especificamente SAXON
		System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
		// Creamos el "factory" para obtener objetos para crear transformaciones.
		TransformerFactory f = TransformerFactory.newInstance();

		System.out.println("Abriendo streams para XML, XSLT y HTML...");

		// Creamos los streams para la entrada XML, la hoja XSLT y para la salida HTML
		try (InputStream xslInputStream = new FileInputStream(XSLT);
				InputStream xmlInputStream = new FileInputStream(XML);
				OutputStream htmlOutputStream = new FileOutputStream(HTML)) {

			// Creamos los objetos "fuente" y "resultado" para cada uno de los streams
			// abiertos.
			StreamSource xslSrc = new StreamSource(xslInputStream);
			StreamSource xmlSrc = new StreamSource(xmlInputStream);
			StreamResult htmlRes = new StreamResult(htmlOutputStream);

			// Creaos el objeto que realmente realiza la transformación. Recibe un objeto
			// "fuente" con el que le pasamos la XSLT que debe aplicar.
			Transformer t = f.newTransformer(xslSrc);
			
			System.out.println("Realizando la transformación...");

			// Realizamos la transformación, convirtiendo la fuent XML en resultado HTML.
			t.transform(xmlSrc, htmlRes);
		}
		
		System.out.println("Transformación finalizada.");
		
	}

}
