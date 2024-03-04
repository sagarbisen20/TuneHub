package com.example.demo.entity;

public class LoginData 
{
	String email;
	String Password;
	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginData(String email, String password) {
		super();
		this.email = email;
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "LoginData [email=" + email + ", Password=" + Password + "]";
	}

}
