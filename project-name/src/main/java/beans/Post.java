package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private String id;
	
	@Column(name = "MENSAJE")
	private String texto;
	
	public Post(){
		
	}
	
	public Post(String id,String txt){
		this.id = id;
		this.texto = txt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
