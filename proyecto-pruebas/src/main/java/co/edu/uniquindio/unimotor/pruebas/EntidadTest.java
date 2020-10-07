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
	@UsingDataSet({"persona.json"})
	
	public void buscarPersonaTest() {
		
		Persona p = entityManager.find(Persona.class, "765");
		Assert.assertEquals("maria@email.com", p.getEmail());
		
	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"Persona.json","Vehiculo.json"})
	public void buscarVehiculoTest() {
		
	Vehiculo v = entityManager.find(Vehiculo.class, "987");
		System.out.println(v);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"persona.json"})
	public void eliminarPersonaTest() {
		
		Persona p = entityManager.find(Persona.class, "765");
		entityManager.remove(p);
		
		Persona pBusacada = entityManager.find(Persona.class, "765");
		Assert.assertNotNull( pBusacada);
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"persona.json"})
	public void actualizarPersonaTest() {
		
		Persona p = entityManager.find(Persona.class, "765");
		p.setEmail("maria@gmail.com");
		entityManager.merge(p);
		
		Persona pBusacada = entityManager.find(Persona.class, "765");
		Assert.assertEquals("maria@gmail.com", pBusacada.getEmail());
		
	}

}
