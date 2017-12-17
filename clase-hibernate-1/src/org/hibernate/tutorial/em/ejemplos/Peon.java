package org.hibernate.tutorial.em.ejemplos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Peon {
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	
	@ManyToOne
	private Jefe boss;
	
	public Peon(String nom){
		this.nombre = nom;
	}

	public Jefe getBoss() {
		return boss;
	}

	public void setBoss(Jefe boss) {
		this.boss = boss;
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
