package org.hibernate.tutorial.em.ejemplos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jefe {
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	
	@OneToMany(mappedBy= "boss", cascade = CascadeType.ALL)
	private List<Peon> empleados = new ArrayList<>();
	
	public Jefe(String nom){
		this.nombre = nom;
	}

	public Jefe(){
		
	}
	
	public List<Peon> getLibros() {
		return empleados;
	}
	
	public void addEmpleado(Peon lib){
		this.empleados.add(lib);
		lib.setBoss(this);
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
