package inisg.boot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project implements Serializable {
	private static final long serialVersionUID = 7626224296014027028L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=256, nullable=false)
	private String name;
	
	@Column(length=256, nullable=false)
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
}
