package co.edu.uniquindio.unimotor.ejb;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.unimotor.entidades.Caracteristicas;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Favorito;
import co.edu.uniquindio.unimotor.entidades.FavoritoPK;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.Pregunta;
import co.edu.uniquindio.unimotor.entidades.TipoCombustible;
import co.edu.uniquindio.unimotor.entidades.TipoVehiculo;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;
import co.edu.uniquindio.unimotor.excepcion.VehiculoInexistenteException;

/**
 * Session Bean implementation class PersonaEJB
 */
@Stateless
@LocalBean
public class UnimotorEJB implements UnimotorEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor. 
	 */
	public UnimotorEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registrarPersona(Persona persona) throws Exception {

		if(buscarEmail(persona.getEmail()) ) {

			throw new Exception("El email ya se encuentra en uso");

		}


		entityManager.persist(persona);

	}

	public boolean buscarEmail(String email) {

		TypedQuery<Persona> q = entityManager.createNamedQuery("BUSCAR_POR_EMAIL", Persona.class);
		q.setParameter("email", email);

		List<Persona> l = q.getResultList();

		if(l.isEmpty()) {

			return false;
		}

		return true;
	}

	@Override
	public Persona iniciarSesion(String email, String clave) throws Exception{

		TypedQuery<Persona> q= entityManager.createNamedQuery("AUTENTICAR_PERSONA", Persona.class);
		q.setParameter("email", email);
		q.setParameter("clave", clave);

		List<Persona> l = q.getResultList();

		if(l.isEmpty()) {

			throw new Exception("Los datos de autenticaión son incorrectos");
		}

		return l.get(0);
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) throws Exception {
		//		validar que no exista la placa en la bd
		entityManager.persist(vehiculo);

	}

	@Override
	public List<Vehiculo> obtenerListaVehiculos() {
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("LISTA_VEHICULOS", Vehiculo.class);
		return q.getResultList();
	}

	@Override
	public void modificarVehiculo(Vehiculo vehiculo) throws VehiculoInexistenteException {

		Vehiculo buscado = entityManager.find(Vehiculo.class, vehiculo.getId());

		if(buscado==null) {

			throw new VehiculoInexistenteException("El vehiculo no esta registrado");
		}
		entityManager.merge(vehiculo);
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) throws VehiculoInexistenteException {


		Vehiculo buscado = entityManager.find(Vehiculo.class, vehiculo.getId());

		if(buscado==null) {

			throw new VehiculoInexistenteException("El vehiculo no esta registrado");
		}
		entityManager.remove(vehiculo);

	}

	@Override
	public List<Caracteristicas> obtenerListaCaracteristicas() {
		TypedQuery<Caracteristicas> q = entityManager.createNamedQuery("LISTA_CARACTERISTICAS",Caracteristicas.class);
		return q.getResultList();
	}

	@Override
	public List<Ciudad> obtenerListaCidades() {
		TypedQuery<Ciudad> q = entityManager.createNamedQuery("LISTA_CIUDADES",Ciudad.class);
		return q.getResultList();
	}

	@Override
	public List<Modelo> obtenerListaModelos() {
		TypedQuery<Modelo> q = entityManager.createNamedQuery("LISTA_MODELOS",Modelo.class);
		return q.getResultList();
	}

	@Override
	public void enviarEmail(String asunto, String mensaje, String destinatario) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Ciudad obtenerCiudad(Integer id) {

		return entityManager.find(Ciudad.class, id);
	}

	@Override
	public List<TipoVehiculo> obtenerListaTiposVehiculos() {

		return Arrays.asList(TipoVehiculo.values() );
	}

	@Override
	public List<TipoCombustible> obtenerListaTiposCombustible() {
		return Arrays.asList(TipoCombustible.values() );
	}

	@Override
	public List<Transmision> obtenerListaTransmision() {
		return Arrays.asList(Transmision.values() );
	}

	@Override
	public Persona obtenerPersona(Integer id) {

		return entityManager.find(Persona.class, id);
	}

	@Override
	public Modelo obtenerModelo(Integer id) {

		return entityManager.find(Modelo.class, id);
	}

	@Override
	public List<Vehiculo> buscarVehiculos(String busqueda) {
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("BUSCAR_VEHICULOS", Vehiculo.class); 	
		q.setParameter("busqueda", "%"+busqueda+"%");
		
		return q.getResultList();
	}

	@Override
	public Caracteristicas obtenerCaracteristica(Integer id) {
		return entityManager.find(Caracteristicas.class, id);
		
	}

	@Override
	public Vehiculo obtenerVediculo(Integer id) {
		
		return entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void guardarFavorito(Persona persona, Vehiculo vehiculo) {
		Persona p = entityManager.find(Persona.class, persona.getId());
		Vehiculo v = entityManager.find(Vehiculo.class, vehiculo.getId());
		
	if(p!=null && v!=null) {
		entityManager.persist(new Favorito(p,v,new Date()) );
			
		}
		
	}

	@Override
	public void eliminarFavorito(Persona persona, Vehiculo vehiculo) {
		Persona p = entityManager.find(Persona.class, persona.getId());		
		Vehiculo v = entityManager.find(Vehiculo.class, vehiculo.getId());
	
	if(p!=null && v!=null) {
		FavoritoPK llave = new FavoritoPK(p.getId(),v.getId());
		Favorito fav = entityManager.find(Favorito.class,llave);
		entityManager.remove(fav);
	}
		
	}

	@Override
	public Pregunta hacerPregunta(Persona persona, Vehiculo vehiculo, String textoPregunta) throws Exception {
		
		try {
	Pregunta pregunta = null;
	if(persona!=null && vehiculo!=null) {
		pregunta = new Pregunta(textoPregunta, new Date(), persona,vehiculo);
		entityManager.persist(pregunta);
		}else {
			throw new Exception("Es necesario definir una pregunta y un vehiculo para registrar la pregunta");
		}
		return pregunta;
		}catch (Exception e) {
			throw new Exception("Hubo un error al momento de registrar la pregunta");
		}
	}

	@Override
	public List<Pregunta> obtenerPreguntasVehiculo(Integer codigoV) {
		TypedQuery<Pregunta> q = entityManager.createNamedQuery("LISTA_PREGUNTAS", Pregunta.class); 	
		q.setParameter("id",codigoV);
		return q.getResultList();
	}

	@Override
	public List<Caracteristicas> obtenerCaracteristicasVehiculo(Integer codigoV) {
		TypedQuery<Caracteristicas> q = entityManager.createNamedQuery("LISTA_CARACTERISTICAS_VEHICULO", Caracteristicas.class); 	
		q.setParameter("id",codigoV);
		return q.getResultList();
	}

	@Override
	public List<Vehiculo> obtenerListaVehiculosPersona(Integer codigoP) {
		TypedQuery<Vehiculo> q = entityManager.createNamedQuery("BUSCAR_VEHICULOS_PERSONA", Vehiculo.class); 	
		q.setParameter("id",codigoP);
		return q.getResultList();

	}



}
