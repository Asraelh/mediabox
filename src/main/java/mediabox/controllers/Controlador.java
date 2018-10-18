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

import mediabox.interfaces.IUsuarioService;
import mediabox.model.*;
import mediabox.services.*;

@Controller
public class Controlador  {
	@Autowired
	private PruebaService pruebaservice;
	
	
	//*************************************PUBLIC AREA******************************************************************************
	//*************************************************************************************************************************************
	

	/*@RequestMapping("/")
	public String loadCategorias(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("Hola mundo");
		pruebaservice.pruebaconexion();
		
		
		return "index";
	}*/
	
	@RequestMapping("/") 
	
	public String indice(HttpServletRequest req) {
		
		System.err.println("entra indice");
				
		return "index";
	}
	
	@RequestMapping("altausuarios") 
	
	public String altausuarios(HttpServletRequest req) {
		
		System.err.println("redirige a registro");
				
		return "registro";
	}
	
	@Autowired
	private IUsuarioService usuarioservice;
	
	@RequestMapping("/registrarse") 
	public ModelAndView registrarse(HttpServletRequest req) {
		System.err.println("registrandose");
		String mensaje;
		
		ModelAndView modelAndview=new ModelAndView();
		
		if(req.getParameter("user").equals("") || req.getParameter("password").equals("") || req.getParameter("email").equals("") || 
				req.getParameter("nombre").equals("") || req.getParameter("apellidos").equals("") || req.getParameter("alias").equals("")) { 
		
			mensaje="Rellene todos los campos"; 
			
			modelAndview.setViewName("registro");
			modelAndview.addObject("mensaje_registro", mensaje);
		
		}else {
			
			if(req.getParameter("password").equals(req.getParameter("re_password"))){
			
			mensaje=usuarioservice.addusuario(req.getParameter("user"), req.getParameter("password"), req.getParameter("alias"), 
					req.getParameter("nombre"), req.getParameter("apellidos"), req.getParameter("email"));
			
			if(mensaje.equals("Este usuario ya existe")) {
				
				modelAndview.addObject("mensaje_registro", mensaje);
				modelAndview.setViewName("registro");
				
			}else {
			
			modelAndview.addObject("mensaje_login", mensaje);
			modelAndview.setViewName("index");
			
			}
			
		}else {
			
			mensaje="La contraseña introducida no coincide";
			modelAndview.setViewName("registro");
			modelAndview.addObject("mensaje_registro", mensaje);
			
		}
		
		}
		return modelAndview; 
	}
	
	
	
	
	
}
