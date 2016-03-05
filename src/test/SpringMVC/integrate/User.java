package test.SpringMVC.integrate;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private int id;
	@NotEmpty
	private String name;
	private Date birth;

	public User() {
	}

	public User(int id, String name, Date birth) {
		this.id = id;
		this.name = name;
		this.birth = birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birth=" + birth + "]";
	}

}
