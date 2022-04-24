package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio0102;

public class Fecha {

	private int dia; 
	private int mes; 
	private int anio;

	public Fecha() {
		this.setDia(1);
		this.setMes(1);
		this.setAnio(2022);
	}

	public Fecha(int dia, int mes, int anio) {
		this.setDia(dia);
		this.setMes(mes);
		this.setAnio(anio);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		if (dia < 1)
			return;
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if (mes < 1 || mes > 12)
			return;
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	private boolean esBisiesto() {
		return (((this.anio % 4 == 0) && (this.anio % 100 != 0)) || (this.anio % 400 == 0));
	}

//	public boolean fechaCorrecta() {
//		if ((this.dia < 1) || (this.dia > 31) || (this.mes < 1) || (this.mes > 12))
//			return false;
//		switch (this.mes) {
//		case 4, 6, 9, 11:
//			if (this.dia > 30)
//				return false;
//			break;
//		case 2:
//			if (esBisiesto()) {
//				if (this.dia > 29) return false;
//
//			} else {
//				if (this.dia > 28) return false;
//			}
//		}
//		return true;
//	}
//	
	public boolean fechaCorrecta() {
		switch (this.mes) {
		case 1, 3, 5, 7, 8, 10, 12:
			if (this.dia > 0 && this.dia <= 31)
				return true;
			break;
		case 4, 6, 9, 11:
			if (this.dia > 0 && this.dia <= 30)
				return true;
			break;
		case 2:
			if (esBisiesto()) {
				if (this.dia > 0 && this.dia <= 29)
					return true;
			} else {
				if (this.dia > 0 && this.dia <= 28)
					return true;
			}
		}
		return false;
	}

	public void diaSiguiente() {
		//¿Qué pasa si la fecha de partida es incorrecta?
		// Añadiremos excepciones cuando veamos la UT relacionada
		this.dia += 1; // 31/12/2022 -> 32/12/2022
		if (!fechaCorrecta()) {
			this.dia = 1; // 01/12/2022
			this.mes += 1; // 01/13/2022
		}
		if (!fechaCorrecta()) {
			this.mes = 1; // 01/01/2022
			this.anio += 1; // 01/01/2023
		}
	}

	public boolean esMayorQue(Fecha f) {
		// Comparar this con f
		if (this.anio > f.anio)
			return true;
		if (this.anio == f.anio && this.mes > f.mes)
			return true;
		if (this.anio == f.anio && this.mes == f.mes && this.dia > f.dia)
			return true;
		return false;
	}

	public String toString() {
		return String.format("%02d-%02d-%d", this.dia, this.mes, this.anio);
	}

}
