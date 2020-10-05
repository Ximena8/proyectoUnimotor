package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Tabla
 *
 */ 
public class TablaPK  implements Serializable {   
   
	         
	private String idVehiculo;         
	private String idCaracteristicas;
	private static final long serialVersionUID = 1L;

	public TablaPK() {}

	

	public String getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	

	public String getIdCaracteristicas() {
		return this.idCaracteristicas;
	}

	public void setIdCaracteristicas(String idCaracteristicas) {
		this.idCaracteristicas = idCaracteristicas;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof TablaPK)) {
			return false;
		}
		TablaPK other = (TablaPK) o;
		return true
			&& (getIdVehiculo() == null ? other.getIdVehiculo() == null : getIdVehiculo().equals(other.getIdVehiculo()))
			&& (getIdCaracteristicas() == null ? other.getIdCaracteristicas() == null : getIdCaracteristicas().equals(other.getIdCaracteristicas()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getIdVehiculo() == null ? 0 : getIdVehiculo().hashCode());
		result = prime * result + (getIdCaracteristicas() == null ? 0 : getIdCaracteristicas().hashCode());
		return result;
	}
   
   
}
