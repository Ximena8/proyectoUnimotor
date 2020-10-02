package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Table
 *
 */ 
public class TablePK  implements Serializable {   
   
	         
	private String idVehiculo;         
	private String idCaracteristica;
	private static final long serialVersionUID = 1L;

	public TablePK() {}

	

	public String getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	

	public String getIdCaracteristica() {
		return this.idCaracteristica;
	}

	public void setIdCaracteristica(String idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof TablePK)) {
			return false;
		}
		TablePK other = (TablePK) o;
		return true
			&& (getIdVehiculo() == null ? other.getIdVehiculo() == null : getIdVehiculo().equals(other.getIdVehiculo()))
			&& (getIdCaracteristica() == null ? other.getIdCaracteristica() == null : getIdCaracteristica().equals(other.getIdCaracteristica()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getIdVehiculo() == null ? 0 : getIdVehiculo().hashCode());
		result = prime * result + (getIdCaracteristica() == null ? 0 : getIdCaracteristica().hashCode());
		return result;
	}
   
   
}
