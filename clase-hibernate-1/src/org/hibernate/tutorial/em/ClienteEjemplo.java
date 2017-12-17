package org.hibernate.tutorial.em;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ClienteEjemplo {
	
	@Id
	@GeneratedValue
    private Long id;	
	private long cuit;
	private String razonSocial;
	
	@OneToOne(cascade = CascadeType.ALL)	
	private Direccion dir;

	public ClienteEjemplo(){
		
	}
	public ClienteEjemplo(long cuit, String razonSocial) {
		this.cuit = cuit;
		this.razonSocial = razonSocial;
	}
	
    public Long getId() {
		return id;
    }

	public long getCuit() {
		return cuit;
	}
	
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}
}
