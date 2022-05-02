package es.iesclaradelrey.dm1e2122.ut14.ejercicios;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class Customer implements Serializable {
	
	private int customerId;
	private int storeId;
	private String firstName;
	private String lastName;
	private String email;
	private int addressId;
	private boolean active;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;
	
	public Customer(int customerId, int storeId, String firstName, String lastName, String email, int addressId,
			boolean active, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
		super();
		this.customerId = customerId;
		this.storeId = storeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.addressId = addressId;
		this.active = active;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getStoreId() {
		return storeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getAddressId() {
		return addressId;
	}

	public boolean isActive() {
		return active;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}
	
	

}
