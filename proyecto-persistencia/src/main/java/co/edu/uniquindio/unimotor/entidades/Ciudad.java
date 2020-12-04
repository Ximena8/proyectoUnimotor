package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ciudad
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name = "LISTA_PERSONAS_CIUDAD", query = "select p.nombre, p.email, p.direccion from  Ciudad c join c.persona  p where c.nombre = :nombre"),
@NamedQuery(name = "LISTA_CIUDADES", query= "select c from Ciudad c")
})
public class Ciudad implements Serializable {

	  
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre", length = 200, nullable = false)
	private String nombre;
	
	@JsonbTransient
	@OneToMany(mappedBy = "ciudad")
	private List<Persona> persona;
	
	@JsonbTransient
	@OneToMany(mappedBy = "ciudad")
	private List<Vehiculo> Vehiculo;
	
	private static final long serialVersionUID = 1L;

	public Ciudad() {
		super();
	}  
	
	
	public Ciudad(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public List<Persona> getPersona() {
		return persona;
	}


	public void setPersona(List<Persona> persona) {
		this.persona = persona;
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
		Ciudad other = (Ciudad) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombre + "]";
	}


	

	
	
}
