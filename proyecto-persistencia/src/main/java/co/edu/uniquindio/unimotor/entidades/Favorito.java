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
	@Column(name="id_persona", length = 10)
	private String idPersona;   
	@Id
	@Column(name="id_vehiculo", length = 10)
	private String idVehiculo;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "id_Vehiculo", nullable = false)
	private Vehiculo vehiculo;
	
	private static final long serialVersionUID = 1L;

	public Favorito() {
		super();
	}   
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
   
}
