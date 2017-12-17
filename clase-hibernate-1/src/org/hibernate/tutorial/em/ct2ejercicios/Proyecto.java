package org.hibernate.tutorial.em.ct2ejercicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Proyecto {

	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String fechaFin;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Empleado> empleados = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	
	public Proyecto(String nom,String ffin){
		this.nombre = nom;
		this.fechaFin = ffin;
	}
	
	public Proyecto(){
		
	}
	
	//actualizamos ambos extremos de la relacion
	public void addEmpleado(Empleado emp){
		this.empleados.add(emp);
		emp.getProyectos().add(this);
	}
	
	public void removeEmpleado(Empleado emp){
		this.empleados.remove(emp);
		emp.getProyectos().remove(this);
	}
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public long getId() {
		return id;
	}
}
