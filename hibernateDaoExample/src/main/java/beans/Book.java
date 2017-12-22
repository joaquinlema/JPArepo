package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "Title")
	private String title;
	
	@Column(name = "Author")	
	private String author;
	
	public Book(){
		
	}
	
	public Book(String id, String title, String author){
		this.id = id;
		this.title  = title;
		this.author = author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
