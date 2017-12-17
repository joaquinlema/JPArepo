package org.hibernate.tutorial.em.ejemplos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Agencia {
	
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Auto auto;
	
	public Agencia(String nom){
		this.nombre = nom;
	}
	
	public Agencia(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public long getId() {
		return id;
	}
	
}
