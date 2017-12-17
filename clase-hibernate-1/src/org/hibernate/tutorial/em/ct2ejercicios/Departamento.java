package org.hibernate.tutorial.em.ct2ejercicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
	@Id
	@GeneratedValue
	private long id;
	private String codigo,nombre;
	
	@OneToMany(mappedBy = "depto",cascade = CascadeType.ALL)
	private List<Empleado> empleados = new ArrayList<>();
	
	public Departamento(String cod,String nom){
		this.nombre = nom;
		this.codigo = cod;
	}
	
	public Departamento(){
		
	}
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	//actualizamos los extremos de la relacion
	public void addEmpleados(Empleado e){
		this.empleados.add(e);
		e.setDepto(this);
	}
	
	public void removeEmpleados(Empleado e){
		this.empleados.remove(e);
		e.setDepto(null);
	}
	
	public void setId(long id) {
		this.id = id;
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
