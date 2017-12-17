package org.hibernate.tutorial.em.ejemplos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pais {
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Presidente presidente;
	
	public Pais(String nom){
		this.nombre = nom;
	}

	public Presidente getPresidente() {
		return presidente;
	}

	public void setPresidente(Presidente presidente) {
		this.presidente = presidente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}
}
