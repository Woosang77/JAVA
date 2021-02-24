package jdbc_newlec.app.entity;

import java.util.Date;

public class Topic {
	private int id;
	private String title;
	private String description;
	private Date created;
	private int author_id;
	
	public Topic() {
		
	}
	
	public Topic(int id, String title, String description, Date created, int author_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.author_id = author_id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
}
