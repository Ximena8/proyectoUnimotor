package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Table
 *
 */
@Entity

@IdClass(TablePK.class)
public class Table implements Serializable {

	   
	@Id
	@Column(name="id_vehiculo", length = 200, nullable = false)
	private String idVehiculo;   
	@Id
	@Column(name="id_caracteristicas", length = 200, nullable = false)
	private String idCaracteristica;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo", nullable = false)
	private Vehiculo vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_caracteristicas", nullable = false)
	private CaractersiticasAdicionales caractersiticasAdicionales;
	
	private static final long serialVersionUID = 1L;

	public Table() {
		super();
	}   
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
   
}
