package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pregunta
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name = "LISTA_PERSONAS_PREGUNTA_VEHICULO", query = "select distinct p.persona from Pregunta p where p.vehiculo.id = :id"),
@NamedQuery(name = "LISTA_PREGUNTAS", query = "select p from Pregunta p where p.vehiculo.id = :id")
})
public class Pregunta implements Serializable {

	   
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="exto", nullable = false)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP )
	@Column(name="fecha_publicacion", nullable = false)
	private Date fechaPublicacion;
	
	@ManyToOne()
	@JoinColumn(name = "id_persona", nullable = false) 
	private Persona persona;
	
	@ManyToOne()
	@JoinColumn(name = "id_vehiculo", nullable = false) 
	private Vehiculo vehiculo;
	
	@ManyToOne()
	@JoinColumn(name = "id_pregunta") 
	private Pregunta respuesta;
	
	@OneToMany(mappedBy = "respuesta")
	private List<Pregunta> repuestas;
		
	
	private static final long serialVersionUID = 1L;

	public Pregunta() {
		super();
	}  
	
	
	


	public Pregunta(String texto, Date fechaPublicacion, Persona persona, Vehiculo vehiculo) {
		super();
		this.texto = texto;
		this.fechaPublicacion = fechaPublicacion;
		this.persona = persona;
		this.vehiculo = vehiculo;
	}





	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getPregunta() {
		return this.texto;
	}

	public void setPregunta(String texto) {
		this.texto = texto;
	}   
	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPregunta(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	

	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	

	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	

	

	public Pregunta getRespuesta() {
		return respuesta;
	}


	public void setRespuesta(Pregunta respuesta) {
		this.respuesta = respuesta;
	}


	


	public List<Pregunta> getRepuestas() {
		return repuestas;
	}


	public void setRepuestas(List<Pregunta> repuestas) {
		this.repuestas = repuestas;
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
		Pregunta other = (Pregunta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", pregunta=" + texto + ", fechaPregunta=" + fechaPublicacion + "]";
	}

      
	
}
