package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tabla
 *
 */
@Entity

@IdClass(VehiculoCaracteristicasPK.class)
public class VehiculoCaracteristicas implements Serializable {

	   
	@Id
	@Column(name="idVehiculo")
	private Integer idVehiculo;   
	@Id
	@Column(name="idaracteristicas")
	private Integer idCaracteristicas;
	
	@ManyToOne()
	@JoinColumn(name = "id_caracteristicas", nullable = false)
	private Caracteristicas caracteristicas;
	
	
	@ManyToOne()
	@JoinColumn(name = "id_vehiculo", nullable = false)
	private Vehiculo vehiculo;
	
	
	private static final long serialVersionUID = 1L;

	public VehiculoCaracteristicas() {
		super();
	} 
	
	
	public VehiculoCaracteristicas(Integer idVehiculo, Integer idCaracteristicas) {
		super();
		this.idVehiculo = idVehiculo;
		this.idCaracteristicas = idCaracteristicas;
	}


	public Integer getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}   
	public Integer getIdCaracteristicas() {
		return this.idCaracteristicas;
	}

	public void setIdCaracteristicas(Integer idCaracteristicas) {
		this.idCaracteristicas = idCaracteristicas;
	}
	
	
	
	public Caracteristicas getCaracteristicasAdicionales() {
		return caracteristicas;
	}


	public void setCaracteristicasAdicionales(Caracteristicas caracteristicas) {
		this.caracteristicas = caracteristicas;
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
		VehiculoCaracteristicas other = (VehiculoCaracteristicas) obj;
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


	@Override
	public String toString() {
		return "VehiculoCaracteristicas [idVehiculo=" + idVehiculo + ", idCaracteristicas=" + idCaracteristicas + "]";
	}

	
   
}
