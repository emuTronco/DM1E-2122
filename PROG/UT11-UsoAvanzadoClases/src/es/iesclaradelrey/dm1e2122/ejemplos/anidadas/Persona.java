// Clase Fecha que está anidada dentro de la clase Persona.
// Como es privada, la clase Fecha no se podrá usar desde 
// ningún sitio fuera de la clase Persona.

package es.iesclaradelrey.dm1e2122.ejemplos.anidadas;

public class Persona {
	private Fecha fechaCreacion;

	public String getFechaCreacion() {
		return this.fechaCreacion.toString();
	}

	public void setFechaCreacion(int dia, int mes, int anio) {
		this.fechaCreacion.setDia(dia);
		this.fechaCreacion.setMes(mes);
		this.fechaCreacion.setAnio(anio);

	}

	public Persona() {
		this.fechaCreacion = new Fecha(1, 1, 2022);
	}

	public String toString() {
		return "Fecha de creación: " + this.fechaCreacion.toString();
	}

	private class Fecha {
		private int dia, mes, anio;

		public Fecha(int dia, int mes, int anio) {
			this.dia = dia;
			this.mes = mes;
			this.anio = anio;
		}

		@SuppressWarnings("unused")
		int getDia() {
			return dia;
		}

		public void setDia(int dia) {
			this.dia = dia;
		}

		@SuppressWarnings("unused")
		public int getMes() {
			return mes;
		}

		public void setMes(int mes) {
			this.mes = mes;
		}

		@SuppressWarnings("unused")
		public int getAnio() {
			return anio;
		}

		public void setAnio(int anio) {
			this.anio = anio;
		}

		public String toString() {
			return dia + "-" + mes + "-" + anio;

		}

		@SuppressWarnings("unused")
		public boolean esCorrecta() {

			switch (mes) {
			case 1:
				if (dia > 31) {
					return false;
				}

				

			}
			
			return true;
			
		}
	}
}
