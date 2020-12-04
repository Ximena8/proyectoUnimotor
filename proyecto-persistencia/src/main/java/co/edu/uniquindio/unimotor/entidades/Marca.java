package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Marca
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "LISTA_MARCAS", query = "select m from Marca m"),
	@NamedQuery(name = "MARCA_POR_NOMBRE", query = "select m from Marca m where m.nombre = :nombre"),
	@NamedQuery(name = "MARCA_MARCAS_QUERY", query = "select m from Marca m where m.nombre  like :nombre")
	
})

public class Marca implements Serializable {

	   
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre", length = 200, nullable = false)
	private String nombre;
	
	@JsonbTransient
	@OneToMany(mappedBy = "marca")
	private List<Modelo> modelo;
	
	private static final long serialVersionUID = 1L;

	public Marca() {
		super();
	}  
	
	
	public Marca(Integer id, String nombre) {
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
		Marca other = (Marca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Marca [id=" + id + ", nombre=" + nombre + "]";
	}


	
}
