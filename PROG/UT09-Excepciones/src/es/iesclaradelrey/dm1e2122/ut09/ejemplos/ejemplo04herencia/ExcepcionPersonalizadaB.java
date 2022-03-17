package es.iesclaradelrey.dm1e2122.ut09.ejemplos.ejemplo04herencia;

public class ExcepcionPersonalizadaB extends RuntimeException{

	public ExcepcionPersonalizadaB() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected ExcepcionPersonalizadaB(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExcepcionPersonalizadaB(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExcepcionPersonalizadaB(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExcepcionPersonalizadaB(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
