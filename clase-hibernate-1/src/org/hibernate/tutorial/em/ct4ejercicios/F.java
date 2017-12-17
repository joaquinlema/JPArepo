package org.hibernate.tutorial.em.ct4ejercicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class F {
	
	@Id
	@GeneratedValue
	private long id;
	private String f1,f2;
	private int f3;
	
	@ManyToMany(mappedBy="fs",cascade=CascadeType.ALL)
	private List<E> es = new ArrayList<E>();
	
	public F(){
		
	}
	
	public void addEs(E e){
		this.es.add(e);
	}
	
	public void removeEs(E e){
		this.es.remove(e);
	}
	
	public List<E> getEs() {
		return es;
	}

	public void setEs(List<E> es) {
		this.es = es;
	}

	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	public int getF3() {
		return f3;
	}

	public void setF3(int f3) {
		this.f3 = f3;
	}

	public long getId() {
		return id;
	}
	
}
