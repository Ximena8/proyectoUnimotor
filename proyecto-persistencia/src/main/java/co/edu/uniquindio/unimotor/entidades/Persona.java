package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity

public class Persona implements Serializable {

	   
	@Id
	@Column(name="id", length = 10)
	private String id;
	@Column(name="nombre", length = 200, nullable = false)
	private String nombre;
	@Column(name="email", unique = true, nullable = false)
	private String email;
	@Column(name="clave", unique = true,length = 100, nullable = false)
	private String clave;
	@Column(name="direccion")
	private String direccion;
	@Column(name="genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@ManyToOne()
	@JoinColumn(name = "id_ciudad", nullable = false)
	private Ciudad ciudad;
	
	@OneToMany(mappedBy = "persona")
	private List<Telefono> telefono;
	
	@OneToMany(mappedBy = "persona")
	private List<Favorito> favorito;
	
	@OneToMany(mappedBy = "persona")
	private List<Pregunta> Pregunta;
	
	@OneToMany(mappedBy = "persona")
	private List<Vehiculo> vehiculo;
	
	private static final long serialVersionUID = 1L;

	public Persona() {
		super();
	}   
	
	

	public Ciudad getCiudad() {
		return ciudad;
	}



	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}



	public Persona(String id, String nombre, String email, String clave, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
		this.direccion = direccion;
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
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	



	public Genero getGenero() {
		return genero;
	}



	public void setGenero(Genero genero) {
		this.genero = genero;
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	
	
   
}
