package com.lucatic.agenda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lucatic.agenda.dao.DAOPersona;
import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.model.Personas;



@Controller
public class HomeController {
	
	@Autowired
	private DAOPersona daoPersona;
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		//Falta userService
		List<Personas> listper = daoPersona.findAll();
		ModelAndView model = new ModelAndView("Hola");
		model.addObject("Hola", listper);
		return model;
	}
	
//	@Autowired
//private UserService userService;
/*
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		List<User> listUsers = userService.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new User());
		return model;		
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.get(userId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", user);
		return model;		
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		userService.delete(userId);
		return new ModelAndView("redirect:/");		
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) {
		userService.saveOrUpdate(user);
		return new ModelAndView("redirect:/");
	}
	*/
}
