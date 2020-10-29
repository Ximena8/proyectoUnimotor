package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.Embeddable;

/**
 * ID class for entity: Favorito
 *
 */ 
@Embeddable
public class FavoritoPK  implements Serializable {   
 
	private Integer idPersona;         
	private Integer idVehiculo;
	private static final long serialVersionUID = 1L;

	public FavoritoPK() {}

	

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	

	public Integer getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
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
