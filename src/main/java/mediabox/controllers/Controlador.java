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
	
	//*************************************PRUEBA AREA******************************************************************************
	//*************************************************************************************************************************************
	
@RequestMapping("/prueba") 
	
	public String prueba(HttpServletRequest req) {
		
		System.out.println("prueba");
		List pruebas =pruebaservice.pruebaSelect();
		pruebas.forEach(u-> System.out.println(u));
				
		return "index";
	}
	
	
	
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
	
	@RequestMapping("admin_usuario") 
	
	public String administrarusuario(HttpServletRequest req) {
		
		System.err.println("redirige a admin_usuario");
				
		return "admin_usuario";
	}
	
	
	
	@RequestMapping("pelis") 
	
	public String peliculas(HttpServletRequest req) {
		
		System.err.println("redirige a admin_usuario");
				
		return "peliculas";
	}
	
	@RequestMapping("series") 
	
	public String series(HttpServletRequest req) {
		
		System.err.println("redirige a series");
				
		return "series";
	}
	
	@RequestMapping("fav_pelis") 
	
	public String peliculasfav(HttpServletRequest req) {
		
		System.err.println("redirige a peliculas favoritas");
				
		return "peliculas_favoritas";
	}
	
	@RequestMapping("fav_series") 
	
	public String seriesfav(HttpServletRequest req) {
		
		System.err.println("redirige a series favoritas");
				
		return "series_favoritas";
	}
	
	@RequestMapping("cerrarSesion") 
	
	public String cerrarSesion(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		session.invalidate();
				
		return "index";
	}
	
	@RequestMapping("addusuario") 
	public ModelAndView registrarse(HttpServletRequest req) {
		System.err.println("registrandose");
		String mensaje;
		
		String user=req.getParameter("usu");
		String pass=req.getParameter("password");
		String repass=req.getParameter("re_password");
		String email=req.getParameter("email");
		String alias="";
		//String alias=req.getParameter("alias");
		String nombre="";
		String apellidos="";
		/*String nombre=req.getParameter("nombre");
		String apellidos=req.getParameter("apellidos");*/
	
		ModelAndView modelAndview=new ModelAndView();
		
		System.err.println("Usuario: " + user + " Pass: " + pass + " Repass: " + repass + " email: " + email);
		
		/*if(user.equals("") ||pass.equals("") || email.equals("") || 
				nombre.equals("") || apellidos.equals("") || alias.equals("")) { */
		
		if(user.equals("") ||pass.equals("") || repass.equals("") || email.equals("")) {
		
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
				
			}else if(mensaje.equals("Este email ya existe")){
				
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
	
	@RequestMapping("/iniSesion") 
	public ModelAndView iniciosesion(HttpServletRequest req) {
		System.err.println("entra en inicio sesion");
		HttpSession session = req.getSession(true);
		
		String user=req.getParameter("user");
		String password=req.getParameter("password");
		
		String mensaje;
		
		ModelAndView modelAndview=new ModelAndView(); 
		
		if(user.equals("") || password.equals("")) {
		
			mensaje="Rellene todos los campos"; 
			
			
		}else {
			
			Usuario usuario=usuarioservice.comprobarusuario(user, password); //El Usuario que genera solo tiene id y password
		
		if(usuario==null) { 
			
			mensaje="Usuario o contraseña incorrecto"; 
			
			
		}else {
			
			session.setAttribute("usr", usuario);
			
			modelAndview.addObject("usr", user);
			
			mensaje="Sesión iniciada";
			
		}
		}	
			modelAndview.setViewName("index");
			modelAndview.addObject("mensaje_login", mensaje);
			return modelAndview; 
	
	}
	
	
	
}
