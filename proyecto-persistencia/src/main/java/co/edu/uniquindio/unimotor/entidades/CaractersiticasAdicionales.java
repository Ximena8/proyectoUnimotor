package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CaractersiticasAdicionales
 *
 */
@Entity

public class CaractersiticasAdicionales implements Serializable {

	   
	@Id
	@Column(name="id", length = 10)
	private String id;
	@Column(name="nombre", length = 200, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "caractersiticasAdicionales")
	private List<Table> table;
	
	private static final long serialVersionUID = 1L;

	public CaractersiticasAdicionales() {
		super();
	}   
	
	
	public CaractersiticasAdicionales(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		CaractersiticasAdicionales other = (CaractersiticasAdicionales) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
	
}
