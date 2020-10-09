package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Favorito
 *
 */
@Entity

@IdClass(FavoritoPK.class)
public class Favorito implements Serializable {

	   
	@Id
	@Column(name="idPersona")
	private Integer idPersona;   
	@Id
	@Column(name="idvehiculo1", length = 10)
	private Integer idVehiculo;
	
	@ManyToOne()
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	@ManyToOne()
	@JoinColumn(name = "id_vehiculo", nullable = false)
	private Vehiculo vehiculo;
	
	private static final long serialVersionUID = 1L;

	public Favorito() {
		super();
	} 
	
	
	
	public Favorito(Integer idPersona, Integer idVehiculo) {
		super();
		this.idPersona = idPersona;
		this.idVehiculo = idVehiculo;
	}



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
	  
	
	
	
	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public Vehiculo getVehiculo() {
		return vehiculo;
	}



	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
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
		Favorito other = (Favorito) obj;
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
		return "Favorito [idPersona=" + idPersona + ", idVehiculo=" + idVehiculo + "]";
	}

     
	
}
