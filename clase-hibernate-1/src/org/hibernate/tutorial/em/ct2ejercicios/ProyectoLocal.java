package org.hibernate.tutorial.em.ct2ejercicios;

import javax.persistence.Entity;

@Entity
public class ProyectoLocal extends Proyecto{

	private String provincia;
	private int cantRecursos;
	
	public ProyectoLocal(String nom, String ffin,String prov,int recur) {
		super(nom, ffin);
		this.provincia = prov;
		this.cantRecursos = recur;
	}
	
	public ProyectoLocal(String nom, String ffin){
		super(nom, ffin);
	}
	
	public ProyectoLocal(){
		
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getCantRecursos() {
		return cantRecursos;
	}

	public void setCantRecursos(int cantRecursos) {
		this.cantRecursos = cantRecursos;
	}
	

}
