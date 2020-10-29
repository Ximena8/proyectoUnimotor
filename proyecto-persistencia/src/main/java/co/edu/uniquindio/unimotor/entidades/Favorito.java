package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Favorito
 *
 */
@Entity
public class Favorito implements Serializable {
	
	@EmbeddedId
	private FavoritoPK favoritoPK;
	
	@ManyToOne
	@MapsId("idPersona")
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	@ManyToOne
	@MapsId("idVehiculo")
	@JoinColumn(name = "id_vehiculo", nullable = false)
	private Vehiculo vehiculo;
	
	private static final long serialVersionUID = 1L;

	public Favorito() {
		super();
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
	public String toString() {
		return "Favorito [persona=" + persona + ", vehiculo=" + vehiculo + "]";
	}

	
   
}
