package co.edu.uniquindio.unimotor.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hazelcast.internal.json.ParseException;

import co.edu.uniquindio.unimotor.entidades.Persona;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@RunWith(Arquillian.class)
public class EntidadTest {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class,

				"prueba.war").addPackage(Persona.class.getPackage())
				.addAsResource("persistenceForTest.xml",

						"META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}


	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json","Vehiculo.json"})
	public void buscarVehiculoTest() {
		
	Vehiculo v = entityManager.find(Vehiculo.class, 1);
		System.out.println(v);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void eliminarPersonaTest() throws ParseException{
		
		Persona p = entityManager.find(Persona.class, 2);
		entityManager.remove(p);
		
		Persona pBusacada = entityManager.find(Persona.class,2);
		Assert.assertNull( pBusacada);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	
	public void buscarPersonaTest() {
		
		Persona p = entityManager.find(Persona.class, 5);
		Assert.assertEquals("maria@email.com", p.getEmail());
		
	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void actualizarPersonaTest() throws ParseException{
		
		Persona p = entityManager.find(Persona.class, 4);
		p.setEmail("maria@gmail.com");
		entityManager.merge(p);
		
		Persona pBusacada = entityManager.find(Persona.class, 4);
		Assert.assertEquals("maria@gmail.com", pBusacada.getEmail());
		
	}

}
