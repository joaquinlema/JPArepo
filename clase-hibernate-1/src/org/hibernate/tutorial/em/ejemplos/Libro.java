package org.hibernate.tutorial.em.ejemplos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Libro {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	
	public Libro(String nom){
		this.nombre = nom;
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
