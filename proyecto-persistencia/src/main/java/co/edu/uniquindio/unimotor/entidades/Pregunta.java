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
@NamedQuery(name = "LISTA_PERSONAS_PREGUNTA_VEHICULO", query = "select distinct p.persona from Pregunta p where p.vehiculo.id = :id")

public class Pregunta implements Serializable {

	   
	@Id
	@Column(name="id",nullable = false )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="pregunta", length = 200)
	private String pregunta;
	
	@Temporal(TemporalType.TIMESTAMP )
	private Date fechaPregunta;
	
	@ManyToOne()
	@JoinColumn(name = "id_persona", nullable = false) 
	private Persona persona;
	
	@ManyToOne()
	@JoinColumn(name = "id_vehiculo", nullable = false) 
	private Vehiculo vehiculo;
	
	@ManyToOne()
	@JoinColumn(name = "id_pregunta") 
	private Pregunta Pregunta;
	
	
	private static final long serialVersionUID = 1L;

	public Pregunta() {
		super();
	}  
	
	
	public Pregunta(Integer id, String pregunta, Date fechaPregunta) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.fechaPregunta = fechaPregunta;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}   
	public Date getFechaPregunta() {
		return this.fechaPregunta;
	}

	public void setFechaPregunta(Date fechaPregunta) {
		this.fechaPregunta = fechaPregunta;
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

	

	public void setPregunta(Pregunta pregunta) {
		Pregunta = pregunta;
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
		return "Pregunta [id=" + id + ", pregunta=" + pregunta + ", fechaPregunta=" + fechaPregunta + "]";
	}

      
	
}
