package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Favorito
 *
 */ 
public class FavoritoPK  implements Serializable {   
   
	         
	private String idPersona;         
	private String idVehiculo;
	private static final long serialVersionUID = 1L;

	public FavoritoPK() {}

	

	public String getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	

	public String getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof FavoritoPK)) {
			return false;
		}
		FavoritoPK other = (FavoritoPK) o;
		return true
			&& (getIdPersona() == null ? other.getIdPersona() == null : getIdPersona().equals(other.getIdPersona()))
			&& (getIdVehiculo() == null ? other.getIdVehiculo() == null : getIdVehiculo().equals(other.getIdVehiculo()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getIdPersona() == null ? 0 : getIdPersona().hashCode());
		result = prime * result + (getIdVehiculo() == null ? 0 : getIdVehiculo().hashCode());
		return result;
	}
   
   
}
