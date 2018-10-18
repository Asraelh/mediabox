package mediabox.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mediabox.model.*;
import mediabox.services.*;

@Controller
public class Controlador  {
	@Autowired
	private AnuncianteService anuncianteservice;
	
	
	//*************************************PUBLIC AREA******************************************************************************
	//*************************************************************************************************************************************
	

	@RequestMapping("/")
	public String loadCategorias(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("Hola mundo");
		System.out.println(anuncianteservice.checkUsername("Asraelh", "1234"));
		
		
		return "index";
	}
	
	
	
	
	
	
}
