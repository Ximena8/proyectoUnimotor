package co.edu.uniquindio.unimotor.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class RESTApplication extends Application{
	
   @Override
public Set<Class<?>> getClasses() {
	
	   HashSet<Class<?> > h = new HashSet<Class<?>>();
	   h.add(MarcaREST.class);
	   h.add(VehiculoREST.class);
	return h;
}

}
