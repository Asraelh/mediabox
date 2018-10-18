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
	@Autowired
	private IUsuarioService usuarioservice;
	
	//*************************************PUBLIC AREA******************************************************************************
	//*************************************************************************************************************************************
	

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
	
	
	
	@RequestMapping("/registrarse") 
	public ModelAndView registrarse(HttpServletRequest req) {
		System.err.println("registrandose");
		String mensaje;
		
		String user=req.getParameter("user");
		String pass=req.getParameter("password");
		String repass=req.getParameter("re_password");
		String email=req.getParameter("email");
		String alias=req.getParameter("alias");
		String nombre=req.getParameter("nombre");
		String apellidos=req.getParameter("apellidos");
		
		ModelAndView modelAndview=new ModelAndView();
		
		if(user.equals("") ||pass.equals("") || email.equals("") || 
				nombre.equals("") || apellidos.equals("") || alias.equals("")) { 
		
			mensaje="Rellene todos los campos"; 
			
			modelAndview.setViewName("registro");
			modelAndview.addObject("mensaje_registro", mensaje);
		
		}else {
			
			if(pass.equals(repass)){
			
			mensaje=usuarioservice.addusuario(user, pass, email,alias, 
					nombre, apellidos );
			
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
