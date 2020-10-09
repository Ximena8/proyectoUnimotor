package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Tabla
 *
 */ 
public class VehiculoCaracteristicasPK  implements Serializable {   
   
	         
	private Integer idVehiculo;         
	private Integer idCaracteristicas;
	private static final long serialVersionUID = 1L;

	public VehiculoCaracteristicasPK() {}

	

	public Integer getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	

	public Integer getIdCaracteristicas() {
		return this.idCaracteristicas;
	}

	public void setIdCaracteristicas(Integer idCaracteristicas) {
		this.idCaracteristicas = idCaracteristicas;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof VehiculoCaracteristicasPK)) {
			return false;
		}
		VehiculoCaracteristicasPK other = (VehiculoCaracteristicasPK) o;
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
