package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tabla
 *
 */
@Entity

@IdClass(TablaPK.class)
public class Tabla implements Serializable {

	   
	@Id
	@Column(name="id_vehiculo1", length = 200, nullable = false)
	private String idVehiculo;   
	@Id
	@Column(name="id_caracteristicas1", length = 200, nullable = false)
	private String idCaracteristicas;
	
	@ManyToOne()
	@JoinColumn(name = "id_caracteristicas", nullable = false)
	private CaractersiticasAdicionales caracteristicasAdicionales;
	
	
	@ManyToOne()
	@JoinColumn(name = "id_vehiculo", nullable = false)
	private Vehiculo vehiculo;
	
	
	private static final long serialVersionUID = 1L;

	public Tabla() {
		super();
	} 
	
	
	public Tabla(String idVehiculo, String idCaracteristicas) {
		super();
		this.idVehiculo = idVehiculo;
		this.idCaracteristicas = idCaracteristicas;
	}


	public String getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}   
	public String getIdCaracteristicas() {
		return this.idCaracteristicas;
	}

	public void setIdCaracteristicas(String idCaracteristicas) {
		this.idCaracteristicas = idCaracteristicas;
	}
	
	
	
	public CaractersiticasAdicionales getCaracteristicasAdicionales() {
		return caracteristicasAdicionales;
	}


	public void setCaracteristicasAdicionales(CaractersiticasAdicionales caracteristicasAdicionales) {
		this.caracteristicasAdicionales = caracteristicasAdicionales;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCaracteristicas == null) ? 0 : idCaracteristicas.hashCode());
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
		Tabla other = (Tabla) obj;
		if (idCaracteristicas == null) {
			if (other.idCaracteristicas != null)
				return false;
		} else if (!idCaracteristicas.equals(other.idCaracteristicas))
			return false;
		if (idVehiculo == null) {
			if (other.idVehiculo != null)
				return false;
		} else if (!idVehiculo.equals(other.idVehiculo))
			return false;
		return true;
	}
   
}
