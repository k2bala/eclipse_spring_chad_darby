package com.luv2code.aopdemo;

public class Account {
	private String name;
	private String email;

	public Account() {
	};

	public Account(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", email=" + email + "]";
	}

}
