package org.hibernate.tutorial.em;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class C {

@Id
@GeneratedValue
private long id;
private String c1;
private String c2;

@ManyToMany(mappedBy="cs")
private List<B> bs = new ArrayList<>();


public long getId(){
	return id;
}
public String getAB1() {
	return c1;
}

public void setA1(String b1) {
	this.c1 = b1;
}

public String getB2() {
	return c2;
}

public void setB2(String b2) {
	this.c2 = b2;
}

public List<B> getBs() {
	return bs;
}

}

