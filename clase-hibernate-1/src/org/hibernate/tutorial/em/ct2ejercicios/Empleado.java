package org.hibernate.tutorial.em.ct2ejercicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

@Entity
public class Empleado {

	@Id
	@GeneratedValue
	private long id;
	@NaturalId
	private int legajo;
	private String nombre;
	
	@ManyToOne
	private Departamento depto;
	
	@ManyToMany(mappedBy = "empleados")
	private List<Proyecto> proyectos = new ArrayList<>();
	
	public Empleado(int legajo,String nombre){
		this.legajo = legajo;
		this.nombre = nombre;
	}
	
	public Empleado(){
		
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}

	public long getId() {
		return id;
	}
	
}
