package org.hibernate.tutorial.em.ct2ejercicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Unidad_de_Negocio {

	@Id
	@GeneratedValue
	private long id;
	private String codigo,nombre;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Departamento> departamentos = new ArrayList<>();
	
	public Unidad_de_Negocio(String cod,String nom){
		this.nombre = nom;
		this.codigo = cod;
	}
	
	public Unidad_de_Negocio(){
		
	}
	public void addDepartamento(Departamento depto){
		this.departamentos.add(depto);
	}
	
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
