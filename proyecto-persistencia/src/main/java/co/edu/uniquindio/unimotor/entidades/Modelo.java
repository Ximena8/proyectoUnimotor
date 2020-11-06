package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Modelo
 *
 */
@Entity

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


	public List<Vehiculo> getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(List<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
   
}
