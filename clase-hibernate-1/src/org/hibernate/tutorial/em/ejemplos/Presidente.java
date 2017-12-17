package org.hibernate.tutorial.em.ejemplos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Presidente {
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	
	@OneToOne
	private Pais pais;
	
	public Presidente(String nom){
		this.nombre = nom;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
