package co.edu.uniquindio.unimotor.pruebas;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@RunWith(Arquillian.class)
public class NegocioTest {
	
	@EJB
	private UnimotorEJB personaEJB;

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(UnimotorEJB.class)
				.addPackage(Vehiculo.class.getPackage())
				.addAsResource("persistenceForTest.xml","META-INF/persistence.xml")

				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}
    
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	@UsingDataSet({"unimotor.json"})
	public void iniciarSesionTest() throws Exception {
		
		System.out.println( personaEJB.iniciarSesion("ximena@email.com", "321") );
	}
	
}
