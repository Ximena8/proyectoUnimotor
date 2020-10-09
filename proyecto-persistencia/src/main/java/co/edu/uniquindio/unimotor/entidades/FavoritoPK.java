package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Favorito
 *
 */ 
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime * result + ((idVehiculo == null) ? 0 : idVehiculo.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoritoPK other = (FavoritoPK) obj;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (idVehiculo == null) {
			if (other.idVehiculo != null)
				return false;
		} else if (!idVehiculo.equals(other.idVehiculo))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "FavoritoPK [idPersona=" + idPersona + ", idVehiculo=" + idVehiculo + "]";
	}
 

   
}
