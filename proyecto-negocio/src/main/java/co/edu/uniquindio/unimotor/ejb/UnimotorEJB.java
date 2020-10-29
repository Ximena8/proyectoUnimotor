package co.edu.uniquindio.unimotor.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.unimotor.entidades.Caracteristicas;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Persona;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vehiculo> obtenerListaVehiculo() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudad> obtenerListaCidades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modelo> obtenerListaModelo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enviarEmail(String asunto, String mensaje, String destinatario) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
