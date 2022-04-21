package es.iesclaradelrey.dm1e2122.examenrec2ev.ej2;

import java.util.Objects;

public class Electrodomestico implements Comparable<Electrodomestico> {

	private String marca;
	private String modelo;
	private int ancho;
	private int alto;
	private int fondo;
	private Potencia potencia;

	public Electrodomestico(String marca, String modelo, int ancho, int alto, int fondo, Potencia potencia) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getFondo() {
		return fondo;
	}

	public Potencia getPotencia() {
		return potencia;
	}

	public void setPotencia(Potencia potencia) {
		this.potencia = potencia;
	}

	public int getVolumen() {
		return ancho * alto * fondo;
	}

	@Override
	public String toString() {
		return String.format("%s %s - %d cm cúbicos - Potencia: %s", marca, modelo, getVolumen(), potencia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Electrodomestico other = (Electrodomestico) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo);
	}

	@Override
	public int compareTo(Electrodomestico o) {
		int comparacionMarca = this.marca.compareTo(o.marca);
		if (comparacionMarca == 0) {
			return this.modelo.compareTo(o.modelo);
		}
		return comparacionMarca;
	}

}
