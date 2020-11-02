package co.edu.uniquindio.unimotor.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class EjemploBean {

	
	private String atr1;
	private String atr2;
	
	
	public void cambiar() {
		
		String aux=atr1;
		atr1=atr2;
		atr2=aux;
	}
	
	public String getAtr1() {
		return atr1;
	}
	
	public void setAtr1(String atr1) {
		this.atr1 = atr1;
	}
	
	public String getAtr2() {
		return atr2;
	}
	
	public void setAtr2(String atr2) {
		this.atr2 = atr2;
	}
	
	
}
