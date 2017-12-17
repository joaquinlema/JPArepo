package org.hibernate.tutorial.em;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class A {
	
	@Id
	@GeneratedValue
	private long id;
	private String a1;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private B b;

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public long getId() {
		return id;
	}
}
