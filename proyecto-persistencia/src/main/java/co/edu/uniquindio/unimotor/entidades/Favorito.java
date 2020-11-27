package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.util.Date;

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
	
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name="fecha", nullable = false)
	private Date fecha;
	
	private static final long serialVersionUID = 1L;

	public Favorito() {
		super();
	}   
	
	
	
	public Favorito(Persona persona, Vehiculo vehiculo, Date fecha) {
		super();
		this.persona = persona;
		this.vehiculo = vehiculo;
		this.fecha = fecha;
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
	
	
	
	public FavoritoPK getFavoritoPK() {
		return favoritoPK;
	}
	public void setFavoritoPK(FavoritoPK favoritoPK) {
		this.favoritoPK = favoritoPK;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	@Override
	public String toString() {
		return "Favorito [favoritoPK=" + favoritoPK + ", persona=" + persona + ", vehiculo=" + vehiculo + ", fecha="
				+ fecha + "]";
	}
	
	

	
   
}
