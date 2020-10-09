package co.edu.uniquindio.unimotor.pruebas;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@RunWith(Arquillian.class)
public class unimotorTest {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class,

				"prueba.war").addPackage(Vehiculo.class.getPackage())
				.addAsResource("persistenceForTest.xml",

						"META-INF/persistence.xml")

				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@Test
	public void test() {


	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void testLista() {
		
		TypedQuery <Vehiculo>q = entityManager.createNamedQuery("TODOS_VEHICULO", Vehiculo.class);
		List <Vehiculo> l = q.getResultList();
		
		for(Vehiculo v : l) {
			
			System.out.println(v.getDescripcion() + " " +v.getPrecio());
			
		}
	}
	
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void testListaVehiculoTransmision() {
		
		TypedQuery <Vehiculo>q = entityManager.createNamedQuery("TODOS_VEHICULOS_TRANSMISION", Vehiculo.class);
		q.setParameter("tran", Transmision.AUTOMATICO);
		
		List <Vehiculo> l = q.getResultList();
		
		for(Vehiculo v : l) {
			
			System.out.println(v.getDescripcion() + " " +v.getPrecio());
			
		}
	}
	
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void testAutenticacion() {
		
		TypedQuery <Persona>q = entityManager.createNamedQuery("AUTENTICAR_PERSONA", Persona.class);
		q.setParameter("email", "ximena@email.com");
		q.setParameter("clave", "321");
		
		List <Persona> l = q.getResultList();
		
	   Assert.assertEquals(1, l.size());
		
		
	}
	
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void listaVehiculosTest() {
		
		TypedQuery <Vehiculo>q = entityManager.createNamedQuery("TODOS_VEHICULO", Vehiculo.class);
		q.setMaxResults(3);
		q.setFirstResult(2);
		List<Vehiculo> l = q.getResultList();
		
	 for(Vehiculo vehiculo : l ) {
		 
		 System.out.println(vehiculo);
	 }
		
		
	}
}


