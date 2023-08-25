package com.somesh.model;

public class Student {

	private int id;
	private String name;
	private long mobile;

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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}

	public Student(int id, String name, long mobile) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
	}

}
