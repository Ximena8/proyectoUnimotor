package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: fotoVehiculo
 *
 */
@Entity

public class fotoVehiculo implements Serializable {

	   
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="url", length = 1000)
	private String url;
	
	@ManyToOne()
	@JoinColumn(name = "id_vehiculo", nullable = false)
	private Vehiculo vehiculo;
	
	private static final long serialVersionUID = 1L;

	public fotoVehiculo() {
		super();
	}   
	
	
	public fotoVehiculo(Integer id, String url) {
		super();
		this.id = id;
		this.url = url;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		fotoVehiculo other = (fotoVehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "fotoVehiculo [id=" + id + ", url=" + url + "]";
	}

   
}
