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
	@Column(name="id", length = 10)
	private String id;
	@Column(name="url", length = 100)
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo", nullable = false)
	private Vehiculo vehiculo;
	
	private static final long serialVersionUID = 1L;

	public fotoVehiculo() {
		super();
	}   
	
	
	public fotoVehiculo(String id, String url) {
		super();
		this.id = id;
		this.url = url;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
	
   
}
