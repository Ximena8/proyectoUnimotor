package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehiculo
 *
 */

//consultas
@Entity
@NamedQueries({
	@NamedQuery(name = "TODOS_VEHICULOS", query = "select v from Vehiculo v"),
	@NamedQuery(name = "TODOS_VEHICULOS_TRANSMISION", query = "select v from Vehiculo v where v.transmision = :tran" ),
	@NamedQuery(name = "TODOS_VEHICULOS_ANIO", query = "select v from Vehiculo v where v.anio >= 2011 and v.anio <= 2019" ),
	@NamedQuery(name = "TODOS_VEHICULOS_PRECIO", query = "select v from Vehiculo v where v.precio between :precioMenor and :precioMayor " ),
	@NamedQuery(name = "VEHICULO_DESCRIPCION", query = "select v.modelo.nombre, v.precio,  v.anio from  Vehiculo v where v.descripcion = :descrip"),
	@NamedQuery(name = "LISTA_PREGUNTAS_VEHICULO", query = "select v,p from Vehiculo v left join v.pregunta p "),
	@NamedQuery(name = "LISTA_CARACTERISTICAS_VEHICULO", query = "select C from Vehiculo v join v.caracteristicas c where v.id =:id "),
	@NamedQuery(name = "LISTA_FOTOS_VEHICULO", query = "select v from Vehiculo v  where v.modelo.marca.nombre = :marca and v.vehiculoNuevo = true and v.precio between :precioMin  and :precioMax "),
	@NamedQuery(name = "LISTA_VEHICULOS_CARACTERISTICAS", query = "select distinct v from Vehiculo v join v.caracteristicas c where c.nombre IN :lista" ),
	@NamedQuery(name = "LISTA_VEHICULOS_CARACTERISTICAS_CUENTA", query = "select count(v) from Vehiculo v join v.caracteristicas c where c.id IN :lista group by v  " ),
	@NamedQuery(name = "LISTA_VEHICULOS_POR_MARCA", query = "select v.modelo.marca.id, v.modelo.marca.nombre, count(v) from Vehiculo v  group by v.modelo.marca" ),
	@NamedQuery(name = "TODOS_VEHICULOS_SIN_PREGUNTAS", query = "select v from Vehiculo v where v.pregunta is empty" ),
	@NamedQuery(name = "CANTIDAD_VEHICULOS_POR_TIPO", query = "select v.tipoVehiculo, count(v) from Vehiculo v group by v.tipoVehiculo" ),
	@NamedQuery(name = "VALOR_PROMEDIO_CONDICIONES", query = "select avg(v.precio) from Vehiculo v where v.modelo.marca = :marca and v.vehiculoNuevo = :nuevo and v.ciudad = :ciudad" ),
	@NamedQuery(name = "LISTA_VEHICULOS_TODAS_CARACTERISTICAS", query = "select v from Vehiculo v join v.caracteristicas c where c.id IN :lista group by v having count(v) = :tamLista" ),
//	@NamedQuery(name = "VEHICULO_MAS_COSTOSO_CIUDAD", query = "select v from Vehiculo v where v.vehiculoNuevo = true and v.ciudad.nombre = :ciudad and v.precio = select max(v.precio)"),
	@NamedQuery(name = "VALOR_MAS_COSTOSO_POR_MARCA", query = "select v.modelo.marca.nombre, max(v.precio) from Vehiculo v group by v.modelo.marca" ),
//	@NamedQuery(name = "CIUDAD_CON_MAS_VEHICULOS", query = "select v.ciudad.nombre, count(v)  from Vehiculo v group by v.ciudad order by c desc" )






	 



})


public class Vehiculo implements Serializable {


	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="precio")
	private Integer precio;
	
	@Column(name="descripcion", length = 200, nullable = false)
	private String descripcion;
	
	@Column(name="anio", nullable = false)
	private int anio;
	
	@Column(name="vehiculoNuevo",nullable = false)
	private boolean vehiculoNuevo;

	@ElementCollection
	private ArrayList<String> fotos; 

	@ManyToMany
	private List<Caracteristicas> caracteristicas;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Favorito> favorito;

	@OneToMany(mappedBy = "vehiculo")
	private List<Pregunta> pregunta;


	@ManyToOne()
	@JoinColumn(name = "id_ciudad", nullable = false)
	private Ciudad ciudad;

	@ManyToOne()
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;

	
	
	@ManyToOne()
	@JoinColumn(name = "id_modelo", nullable = false)
	private Modelo modelo;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_combustible",nullable = false)
	private TipoCombustible tipoCombustible;
	

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_vehiculo",nullable = false)
	private TipoVehiculo tipoVehiculo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="transmision",nullable = false)
	private Transmision transmision;
	
	private static final long serialVersionUID = 1L;

	public Vehiculo() {
		super();
	}


	public Vehiculo(Integer id, Integer precio, String descripcion, int anio, boolean vehiculoNuevo) {
		super();
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
		this.anio = anio;
		this.vehiculoNuevo=vehiculoNuevo;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
   
	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	} 

	public boolean getvehiculoNuevo() {
		return this.vehiculoNuevo;
	}

	public void setvehiculoNuevo(boolean anio) {
		this.vehiculoNuevo = vehiculoNuevo;
	} 

	public Ciudad getCiudad() {
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}




	public TipoCombustible getTipoCombustible() {
		return tipoCombustible;
	}


	public void setTipoCombustible(TipoCombustible tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}




	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}




	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	


	public Modelo getModelo() {
		return modelo;
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	


	public ArrayList<String> getFotos() {
		return fotos;
	}


	public void setFotos(ArrayList<String> fotos) {
		this.fotos = fotos;
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


	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", precio=" + precio + ", descripcion=" + descripcion + ", anio=" + anio
				+ ", vehiculoNuevo=" + vehiculoNuevo + "]";
	}


	


	
}
