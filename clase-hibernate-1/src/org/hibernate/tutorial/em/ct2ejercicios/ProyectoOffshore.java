package org.hibernate.tutorial.em.ct2ejercicios;

import javax.persistence.Entity;

@Entity
public class ProyectoOffshore extends Proyecto{

	private String pais,frontOffice;
	
	public ProyectoOffshore(String nom, String ffin,String frontO,String pais) {
		super(nom, ffin);
		this.pais = pais;
		this.frontOffice = frontO;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFrontOffice() {
		return frontOffice;
	}

	public void setFrontOffice(String frontOffice) {
		this.frontOffice = frontOffice;
	}

}
