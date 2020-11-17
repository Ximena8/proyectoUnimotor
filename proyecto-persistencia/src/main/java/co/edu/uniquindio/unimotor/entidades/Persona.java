package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "AUTENTICAR_PERSONA", query = "select p from Persona p where p.email = :email and p.clave = :clave"),
	@NamedQuery(name = "LISTA_FAVORITOS_PERSONA", query = "select f.vehiculo from Persona p, IN (p.favorito) f where p.email = :email"),
	@NamedQuery(name = "LISTA_FAVORITOS_PERSONA2", query = "select f.vehiculo, p.nombre from Persona p, IN (p.favorito) f where p.email = :email"),
	@NamedQuery(name = "LISTA_FAVORITOS_PERSONA_JOIN", query = "select f.vehiculo, p.nombre from Persona p join p.favorito f where p.email = :email"),
	@NamedQuery(name = "LISTA_VEHICULOS_VENTA", query = "select p.email, v from  Persona p left join p.vehiculo v"),
	@NamedQuery(name = "LISTA_CIUDAD_PERSONAS", query = "select new co.edu.uniquindio.unimotor.dto.ConsultaPerssonasCiudadDTO (p.nombre, p.email, p.direccion) from Persona p where p.ciudad.nombre = :nombre"),
	@NamedQuery(name = "LISTA_PERSONAS_ORDENADA", query = "select p from Persona p order by p.nombre asc"),
	@NamedQuery(name = "BUSCAR_POR_EMAIL", query = "select p from Persona p where p.email = :email"),
	@NamedQuery(name = "CANTIDAD_PERSONAS", query = "select count(p) from Persona p "),
	@NamedQuery(name = "LISTA_PERSONAS_GMAIL", query = "select p from Persona p where p.email like :correo")
	
})




public class Persona implements Serializable {

	   
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// No espacios vacios
	
	@NotBlank(message = "El nombre no puede ser vacio")
	@Size( max=200)
	@Column(name="nombre", length = 200, nullable = false)
	private String nombre;
	
	@Email
	@Size(min = 7, max=200, message = "El email debe tener entre 7 y 150 caracteres")
	@NotBlank(message = "El email no puede ser vacio")
	@Column(name="email", nullable = false, length = 200, unique = true)
	private String email;
	
	@NotBlank(message = "La clave no puede ser vacia")
	@Size( max=100)
	@Column(name="clave", length = 100, nullable = false)
	private String clave;
	
	@Size( max=200)
	@Column(name="direccion", length = 200)
	private String direccion;
	
	@ElementCollection
	private List<Integer> telefonos; 
	
	@ManyToOne()
	@JoinColumn(name = "id_ciudad", nullable = false)
	private Ciudad ciudad;
	
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
	
	
	

	public Persona(String nombre, String email, String clave, String direccion, List<Integer> telefonos,
			Ciudad ciudad) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
		this.direccion = direccion;
		this.telefonos = telefonos;
		this.ciudad = ciudad;
	}




	public Ciudad getCiudad() {
		return ciudad;
	}



	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
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



	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + ", clave=" + clave + ", direccion="
				+ direccion + "]";
	}

	
}
