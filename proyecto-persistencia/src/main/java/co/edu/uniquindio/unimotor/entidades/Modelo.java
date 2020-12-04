package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Modelo
 *
 */
@Entity
@NamedQueries({
	
	@NamedQuery(name="LISTA_MODELOS", query="select m from Modelo m")
})

public class Modelo implements Serializable {

	  
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre", length = 200, nullable = false)
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name = "id_marca", nullable = false)
	private Marca marca;
	
	@JsonbTransient
	@OneToMany(mappedBy = "modelo")
	private List<Vehiculo> vehiculo;
	
	private static final long serialVersionUID = 1L;

	public Modelo() {
		super();
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


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getModeloMarca() {
		
		return nombre+" - "+marca.getNombre();
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
		Modelo other = (Modelo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
   
}
