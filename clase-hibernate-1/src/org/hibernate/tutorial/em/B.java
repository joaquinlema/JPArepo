package org.hibernate.tutorial.em;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class B {
	
	@Id
	@GeneratedValue
	private long id;
	private String b1;
	private String b2;

	@OneToMany(mappedBy= "a1", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<A> as = new ArrayList<A>();
	
	@ManyToMany(cascade= CascadeType.ALL)
	private List<C> cs = new ArrayList<>();


	public long getId() {
		return id;
	}

	public String getAB1() {
		return b1;
	}

	public void setA1(String b1) {
		this.b1 = b1;
	}

	public List<A> getAs() {
		return as;
	}

	public String getB2() {
		return b2;
	}

	public void setB2(String b2) {
		this.b2 = b2;
	}
	
	public void setB1(String b2) {
		this.b1 = b2;
	}

	public List<C> getCs() {
		return cs;
	}
	
	public void addAssss(A a){
		a.setB(this);
		as.add(a);
	}
	
	public void removeAsss(A a){
		as.remove(a);
		a.setA1(null);
	}

}
