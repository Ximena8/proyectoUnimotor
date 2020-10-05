package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Telefono
 *
 */
@Entity

public class Telefono implements Serializable {

	@Column(name="clave", length = 200, nullable = false)
	private String clave;
	@Column(name="valor")
	private int valor;   
	@Id
	@Column(name="id", length = 10)
	private String id;
	
	@ManyToOne()
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;
	
	
	private static final long serialVersionUID = 1L;
	
	

	public Telefono() {
		super();
	}   
	
	
	public Telefono(String clave, int valor, String id) {
		super();
		this.clave = clave;
		this.valor = valor;
		this.id = id;
	}


	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}   
	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}   
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
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
		Telefono other = (Telefono) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	
   
}
