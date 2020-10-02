package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehiculo
 *
 */
@Entity

public class Vehiculo implements Serializable {

	   
	@Id
	@Column(name="id", length = 10)
	private String id;
	@Column(name="precio")
	private Integer precio;
	@Column(name="descripcion", length = 200, nullable = false)
	private String descripcion;
	@Column(name="modelo", length = 200, nullable = false)
	private Integer modelo;
	@Column(name="anio")
	private String anio;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Favorito> favortio;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Pregunta> pregunta;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<fotoVehiculo> fotVehiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "id_ciudad", nullable = false)
	private Ciudad ciudad;
	
	@ManyToOne
	@JoinColumn(name = "id_marca", nullable = false)
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_conbustible", nullable = false)
	private TipoCombustible tipoCombustible;
	
	@ManyToOne
	@JoinColumn(name = "id_transmision", nullable = false)
	private Transmision transmision;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_vehiculo", nullable = false)
	private TipoVehiculo tipoVehiculo;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo", nullable = false)
	private Table table;
	
	
	
	private static final long serialVersionUID = 1L;

	public Vehiculo() {
		super();
	}
	
	
	public Vehiculo(String id, Integer precio, String descripcion, Integer modelo, String anio) {
		super();
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
		this.modelo = modelo;
		this.anio = anio;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public Integer getPrecio() {
		return this.precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public Integer getModelo() {
		return this.modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}   
	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
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
		Vehiculo other = (Vehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
