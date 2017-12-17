package org.hibernate.tutorial.em.ct4ejercicios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class D {

	@Id
	@GeneratedValue
	private long id;
	private String d1;
	
	@ManyToOne
	private E e;
	
	public D(){
		
	}
	
	public E getE() {
		return e;
	}

	public void setE(E e1) {
		this.e = e1;
	}

	public String getD1() {
		return d1;
	}

	public void setD1(String d1) {
		this.d1 = d1;
	}

	public long getId() {
		return id;
	}
}
