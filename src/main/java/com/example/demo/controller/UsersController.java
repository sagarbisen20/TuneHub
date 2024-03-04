package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LoginData;
import com.example.demo.entity.Songs;
import com.example.demo.entity.Users;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController 
{
	@Autowired
	UsersService service;
	@Autowired
	SongService ss;

	@PostMapping("/validate")
	public String validateUser(@RequestParam String email, String password
			,HttpSession session, Model model)
	{
//		String email = data.getEmail();
//		String password = data.getPassword();
		if(service.validateUser(email, password)==true) {

			String role=service.getUserRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin"))
			{
				return "adminHome";	
			}
			else {
				Users user = service.getUser(email);
				boolean userStatus = user.isPremium();
				List <Songs> songList = ss.fetchAllSongs();
				model.addAttribute("songs",songList);

				model.addAttribute("isPremium",userStatus);
				return	"customerHome";
			}
		}
		else {
			return "login";
		}
	}

	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user)
	{
		boolean userStatus = service.emailExists(user.getEmail());
		if(userStatus==false)
		{
			service.addUser(user);
			System.out.println("User added");
		}
		else {
			System.out.println("User already exists");	
		}
		return "home";

	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";

	}
}
