package entity;

import java.util.Date;

public class Person {
	private int age;
	private String name;
	private String mobile;
	private String email;
	private String city;
	private Date birthday;
	public Person() {
		super();
	}
	public Person(int age, String name, String mobile, String email,
			String city, Date birthday) {
		super();
		this.age = age;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
