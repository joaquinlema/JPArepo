package org.hibernate.tutorial.em.ejemplos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona {
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Libro> libros = new ArrayList<>();
	
	public Persona(String nom){
		this.nombre = nom;
	}

	public List<Libro> getLibros() {
		return libros;
	}
	
	public void addLibro(Libro lib){
		this.libros.add(lib);
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
