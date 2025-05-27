package com.example.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.todolist.entity.User;
import com.example.todolist.service.UserService;

@Controller
public class AuthController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String processRegister(@ModelAttribute("user") User user, Model model) {
		if (userService.usernameExists(user.getUsername())) {
			model.addAttribute("error", "Usuário já existe.");
			return "register";
		}

		userService.registerUser(user);
		return "redirect:/login";
	}
}
