package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

/**
 * ID class for entity: Modelo
 *
 */ 
public class ModeloPK  implements Serializable {   
   
	         
	private Integer id;         
	private String nombre;
	private static final long serialVersionUID = 1L;

	public ModeloPK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ModeloPK)) {
			return false;
		}
		ModeloPK other = (ModeloPK) o;
		return true
			&& (getId() == null ? other.getId() == null : getId().equals(other.getId()))
			&& (getNombre() == null ? other.getNombre() == null : getNombre().equals(other.getNombre()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getId() == null ? 0 : getId().hashCode());
		result = prime * result + (getNombre() == null ? 0 : getNombre().hashCode());
		return result;
	}
   
   
}
