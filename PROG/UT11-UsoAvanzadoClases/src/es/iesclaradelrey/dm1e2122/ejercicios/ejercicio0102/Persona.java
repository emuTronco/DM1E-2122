package es.iesclaradelrey.dm1e2122.ejercicios.ejercicio0102;

import java.time.LocalDateTime;

public class Persona {
	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String ciudad;
	private Fecha fechaNacimiento;

	
	public Persona(String nombre, String direccion, String codigoPostal, String ciudad, int diaNacimiento,
			int mesNacimiento, int anioNacimiento) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCodigoPostal(codigoPostal);
		this.setCiudad(ciudad);
		this.fechaNacimiento = new Fecha(diaNacimiento, mesNacimiento, anioNacimiento);
	}

	public Persona(String nombre, String direccion, String codigoPostal, String ciudad, Fecha fechaNacimiento) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCodigoPostal(codigoPostal);
		this.setCiudad(ciudad);
		// this.fechaNacimiento = fechaNacimiento; // MAL
		this.fechaNacimiento = new Fecha(fechaNacimiento.getDia(), fechaNacimiento.getMes(), fechaNacimiento.getAnio());
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public Fecha getFechaNacimiento() {
		// return this.fechaNacimiento; // MAL. Si devolvemos referencia, se puede modificar la fecha desde fuera.
		return new Fecha(fechaNacimiento.getDia(), fechaNacimiento.getMes(), fechaNacimiento.getAnio());
	}

	public String getFechaNacimientoAsString() {
		return fechaNacimiento.toString();		
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento =  new Fecha(fechaNacimiento.getDia(), fechaNacimiento.getMes(), fechaNacimiento.getAnio()); // Copiamos el objeto para no referenciarlo desde fuera de la clase persona. 
		// this.fechaNacimiento = fechaNacimiento; // MAL. Si nos quedamos con la referencia el objeto se puede modificar desde fuera de la persona.
	}
	
	public void setFechaNacimiento(int diaNacimiento, int mesNacimiento, int anioNacimiento) {
		this.fechaNacimiento.setDia(diaNacimiento);
		this.fechaNacimiento.setMes(mesNacimiento);
		this.fechaNacimiento.setAnio(anioNacimiento);
	}

	public boolean esMayorDeEdad() {
		LocalDateTime ahora = LocalDateTime.now();
		int anioActual = ahora.getYear();
		int mesActual = ahora.getMonthValue();
		int diaActual = ahora.getDayOfMonth();
		if (anioActual - fechaNacimiento.getAnio() > 18)
			return true;
		if (anioActual - fechaNacimiento.getAnio() == 18 && mesActual > fechaNacimiento.getMes())
			return true;
		if (anioActual - fechaNacimiento.getAnio() == 18 && mesActual == fechaNacimiento.getMes()
				&& diaActual >= fechaNacimiento.getDia())
			return true;
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre: ");
		sb.append(this.nombre);
		sb.append("\nFecha de nacimiento: ");
		sb.append(this.fechaNacimiento);
		sb.append("\nDirección");
		sb.append(this.direccion);
		sb.append("\n");
		sb.append(this.codigoPostal);
		sb.append(" ");
		sb.append(this.ciudad);
		return sb.toString();
	}


}
