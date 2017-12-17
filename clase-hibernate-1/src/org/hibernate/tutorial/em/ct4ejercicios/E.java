package org.hibernate.tutorial.em.ct4ejercicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class E {
	
	@Id
	@GeneratedValue
	private long id;
	private String e1,e2;
	
	@OneToMany(mappedBy="e",cascade=CascadeType.ALL)
	private List<D> ds = new ArrayList<D>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<F> fs = new ArrayList<F>();
	
	public E(){
		
	}
	
	public void addFs(F f){
		this.fs.add(f);
		f.addEs(this);
	}
	
	public void removeFs(F f){
		this.fs.remove(f);
		f.removeEs(this);
	}
	
	public List<F> getFs() {
		return fs;
	}

	public void setFs(List<F> fs) {
		this.fs = fs;
	}
	
	public void addDs(D d){
		this.ds.add(d);
		d.setE(this);
	}
	
	public void removeDs(D d){
		this.ds.remove(d);
		d.setE(null);
	}
	
	public List<D> getDs() {
		return ds;
	}

	public String getE1() {
		return e1;
	}

	public void setE1(String e1) {
		this.e1 = e1;
	}

	public String getE2() {
		return e2;
	}

	public void setE2(String e2) {
		this.e2 = e2;
	}

	public long getId() {
		return id;
	}
	
	
}
