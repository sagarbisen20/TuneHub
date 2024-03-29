package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
@Service
public class UsersServiceImplementation implements UsersService {

	@Autowired
	UsersRepository ur;
	@Override
	public String addUser(Users user) {
		ur.save(user);
		return "user added succesfully";
	}
	@Override
	public boolean emailExists(String email) {
		if(ur.findByEmail(email)== null)
		{
			return false;
		}
		else {
			return true;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
		Users user = ur.findByEmail(email);
		String db_pass = user.getPassword();
		if(password.equals(db_pass))
		{
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String getUserRole(String email) {
		Users user =ur.findByEmail(email);
		return user.getRole();
	}
	@Override
	public Users getUser(String email) {

		return ur.findByEmail(email);
	}
	@Override
	public void updateUser(Users user) 
	{
		ur.save(user);	
	}
}
