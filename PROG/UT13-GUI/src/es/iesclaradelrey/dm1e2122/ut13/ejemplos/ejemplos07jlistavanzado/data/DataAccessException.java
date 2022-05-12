package es.iesclaradelrey.dm1e2122.ut13.ejemplos.ejemplos07jlistavanzado.data;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String sentenciaEjecutada;
	

	public DataAccessException(String sentenciaEjecutada) {
		this.sentenciaEjecutada = sentenciaEjecutada;
	}

	public DataAccessException(String sentenciaEjecutada, String message) {
		super(message);
		this.sentenciaEjecutada = sentenciaEjecutada;
	}

	public DataAccessException(String sentenciaEjecutada, Throwable cause) {
		super(cause);
		this.sentenciaEjecutada = sentenciaEjecutada;
	}

	public DataAccessException(String sentenciaEjecutada, String message, Throwable cause) {
		super(message, cause);
		this.sentenciaEjecutada = sentenciaEjecutada;
	}

	public DataAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
