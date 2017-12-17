package org.hibernate.tutorial.em.ct2ejercicios;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private long id;
	private String cuit,nombre;
	
	public Cliente(String cuit,String nom){
		this.nombre = nom;
		this.cuit = cuit;
	}
	
	public Cliente(){
		
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
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
