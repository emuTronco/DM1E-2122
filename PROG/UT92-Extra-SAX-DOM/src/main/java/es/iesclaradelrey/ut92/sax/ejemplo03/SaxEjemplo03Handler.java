package es.iesclaradelrey.ut92.sax.ejemplo03;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxEjemplo03Handler extends DefaultHandler {

	// TODO: Hacer que las listas de pedidos y de clientes se llenen.

	private List<Customer> customers = new ArrayList<>();
	private List<Order> orders = new ArrayList<>();
	
	private Customer currentCustomer = null;

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
		if (qName.equals("Customer")) {
			this.currentCustomer = new Customer();
		}
		if (qName.equals("CompanyName")) {
			currentCustomer.setCompanyName();
		}
		System.out.printf("Inicio de elemento %s\n", qName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.printf("Fin de elemento %s\n", qName);
		if (qName.equals("Customer")) {
			this.customers.add(currentCustomer);
		}
	}

	public List<Customer> getParsedCustomers() {
		return this.customers;
	}

	public List<Order> getParsedOrders() {
		return this.orders;
	}
}
