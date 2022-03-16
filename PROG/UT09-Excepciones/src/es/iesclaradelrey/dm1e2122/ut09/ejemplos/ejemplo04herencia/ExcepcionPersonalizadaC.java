package es.iesclaradelrey.dm1e2122.ut09.ejemplos.ejemplo04herencia;

public class ExcepcionPersonalizadaC extends RuntimeException{
	
	public ExcepcionPersonalizadaC() {
	}

	public ExcepcionPersonalizadaC(String message, Throwable cause, 
				boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcepcionPersonalizadaC(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionPersonalizadaC(String message) {
		super(message);
	}

	public ExcepcionPersonalizadaC(Throwable cause) {
		super(cause);
	}
}



