package co.edu.uniquindio.unimotor.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Marca;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.Persona;

/**
 * Session Bean implementation class SetupEJB
 */
@Singleton
@LocalBean
@Startup
public class SetupEJB {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor. 
	 */
	public SetupEJB() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void config() {

		TypedQuery<Long> q = entityManager.createNamedQuery("CANTIDAD_PERSONAS", Long.class);

		if(q.getSingleResult() == 0) {

			Ciudad c1 = new Ciudad();
			c1.setNombre("Armenia");
			entityManager.persist(c1);

			Ciudad c2 = new Ciudad();
			c2.setNombre("Medellín");
			entityManager.persist(c2);

			Ciudad c3 = new Ciudad();
			c3.setNombre("Perira");
			entityManager.persist(c3);

			List<Integer> tels = new ArrayList<Integer>();
			tels.add(12345);
			tels.add(34567);
			tels.add(34567);

			//        	Map<String, String> tels = new HashMap<>();
			//        o	tels.put("casa","1234");
			//        	tels.put("celular","5678");
			//        	tels.put("trabajo","4321");

			Persona p = new Persona("Ximena","ximena@email.com", "123", "calle 26 norte", tels, c1);
			entityManager.persist(p);

			Persona p1 = new Persona("maria","maria@email.com", "123", "calle 28 norte", tels, c2);
			entityManager.persist(p1);
			
			Marca marca = new Marca();
			marca.setNombre("Chevrolet");
			entityManager.persist(marca);

			Modelo modelo = new Modelo();
			modelo.setMarca(marca);
			modelo.setNombre("Spark GT");
			entityManager.persist(modelo);

		}



	}

}
